package org.zk.application.core.distconfigure.impl;


import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.zookeeper.*;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.NIOServerCnxn;
import org.springframework.util.CollectionUtils;
import org.zk.application.core.distconfigure.api.WriteConfigure;
import org.zk.application.core.exception.ZkException;
import org.zk.application.core.zookeeper.ZooKeeperConfig;

/**
 * zookeeper实现
 *
 * @author shuhong.li 2015年12月24日
 */
public class ZooKeeperWriteConfigure implements WriteConfigure {
    public static final Logger logger = Logger.getLogger(ZooKeeperWriteConfigure.class);

    private ZooKeeperConfig zkConfig;

    private ZooKeeper zk;

    private String rootLocation;

    private static final CountDownLatch latch = new CountDownLatch(1);

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
            rootLocation = zkConfig.getRootLoaction();
            if (zk.exists(zkConfig.getRootLoaction(), false) == null) {
                zk.create(rootLocation, rootLocation.getBytes("utf-8"),
                        Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (Exception ex) {
            throw new ZkException(ex.getMessage());
        }
    }

    @Override
    public boolean writeConfigure(Map<String, String> configure)
            throws ZkException {
        if (zkConfig == null || zk == null) {
            throw new ZkException("ZooKeeperWriteConfigure must init");
        }
        if (CollectionUtils.isEmpty(configure)) {
            return false;
        }
        ;
        try {
            Iterator<String> iterator = configure.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = configure.get(key);
                String node = rootLocation + "/" + key;
                if (zk.exists(node, false) == null) {
                    zk.create(node, value.getBytes("utf-8"),
                            Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                } else {
                    updateConfigure(key, value);
                }

            }
            return true;
        } catch (Exception ex) {
            throw new ZkException(ex.getMessage());
        }
    }

    @Override
    public boolean updateConfigure(String key, String value) throws ZkException {
        if (zkConfig == null || zk == null) {
            throw new ZkException("ZooKeeperWriteConfigure must init");
        }
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            throw new ZkException("key and value must be not null or empty");
        }
        String node = rootLocation + "/" + key;
        try {
            Stat stat = zk.exists(node, false);
            if (stat == null) {
                zk.create(node, value.getBytes("utf-8"),
                        Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }else{
                zk.setData(node,value.getBytes("utf-8"),-1);
            }
        } catch (Exception ex) {
            throw new ZkException(ex.getMessage());
        }

        return true;
    }


    public ZooKeeperConfig getZkConfig() {
        return zkConfig;
    }

    public void setZkConfig(ZooKeeperConfig zkConfig) {
        this.zkConfig = zkConfig;
    }


}
