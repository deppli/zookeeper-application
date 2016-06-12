package org.zk.application.core.distconfigure.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.util.CollectionUtils;
import org.zk.application.core.distconfigure.api.ReadConfigure;
import org.zk.application.core.exception.ZkException;
import org.zk.application.core.zookeeper.ZooKeeperConfig;

/**
 * zookeeper实现
 * 
 * @author shuhong.li 2015年12月24日
 * 
 */
public class ZooKeeperReadConfigure implements ReadConfigure {
	private static final Logger logger = Logger
			.getLogger(ZooKeeperReadConfigure.class);

	private ZooKeeperConfig zkConfig;

	private ZooKeeper zk;

	private String rootLocation;

	private static final CountDownLatch latch = new CountDownLatch(1);

	private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<String, String>();

	public void init() throws ZkException {
		if (zkConfig == null) {
			zkConfig = new ZooKeeperConfig();
		}
		try {
			zk = new ZooKeeper(zkConfig.getAddress(), zkConfig.getTimeout(),
					new Watcher() {
						public void process(WatchedEvent event) {
							if (event.getState() == Event.KeeperState.SyncConnected) {
								latch.countDown();
							}

						}
					});
			latch.await();
			rootLocation = zkConfig.getRootLoaction() ;
			watchRoot();
		} catch (Exception ex) {
			throw new ZkException(ex);
		}
	}

	@Override
	public Map<String, String> readAllConfigure() {

		return cache;
	}

	@Override
	public String readConfigure(String key) {

		return cache.get(key);
	}

	private void watchRoot() throws ZkException {
		if (StringUtils.isBlank(rootLocation) || zk == null) {
			throw new ZkException("ZooKeeperReadConfigure must init");
		}
		try {
			Stat stat = zk.exists(rootLocation, new Watcher() {

				@Override
				public void process(WatchedEvent event) {
					if (event.getType() == EventType.NodeCreated) {
						try {
							watchNode();
						} catch (ZkException e) {
							logger.error("监听节点发生异常", e);
						}
					}

				}

			});

			if (stat != null) {
				watchNode();
			}
		} catch (Exception ex) {
			throw new ZkException(ex);
		}
	}

	public void watchNode() throws ZkException {
		try {
			List<String> znodes = zk.getChildren(rootLocation, new Watcher() {

				@Override
				public void process(WatchedEvent event) {
					try {
						watchNode();
					} catch (ZkException e) {
						logger.error("监听节点发生异常", e);
					}
				}

			});
			
			if (!CollectionUtils.isEmpty(znodes)) {
				for (String znode : znodes) {
					watchData(znode);
				}

			}
		} catch (Exception ex) {
			throw new ZkException(ex);
		}
	}

	public void watchData(String znode) throws ZkException {
		try {
			byte[] bytes = zk.getData(rootLocation+"/"+znode, new Watcher() {

				@Override
				public void process(WatchedEvent paramWatchedEvent) {
					if (paramWatchedEvent.getType() != EventType.None) {
						try {
							watchData(paramWatchedEvent.getPath());
						} catch (Exception ex) {
							logger.error("监听数据发生异常", ex);
						}
					}

				}

			}, null);		
			logger.info("节点 znode:"+znode+",data:"+new String(bytes,"utf-8"));
			znode = znode.substring(0, znode.length()-1);
			cache.put(znode,new String(bytes,"utf-8"));
		} catch (Exception ex) {
			throw new ZkException(ex);
		}
	}

}
