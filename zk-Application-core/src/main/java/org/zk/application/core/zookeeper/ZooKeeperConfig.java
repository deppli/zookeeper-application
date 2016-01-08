package org.zk.application.core.zookeeper;

/**
 * 
 * @author shuhong.li 2015年12月23日 
 * zookeeper config
 */
public class ZooKeeperConfig {
	/**
	 * zookeeper连接地址 
	 * 默认:127.0.0.1:2181 
	 * 支持集群
	 */
	private String address = "127.0.0.1:2181";

	/**
	 * session超时时间
	 * 默认:5000
	 */
	private int timeout = 5000;
	/**
	 * zookeeper跟路径 
	 * 默认:/Services
	 */
	private String rootLoaction = "/Dist";

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getRootLoaction() {
		return rootLoaction;
	}

	public void setRootLoaction(String rootLoaction) {
		this.rootLoaction = rootLoaction;
	}

}
