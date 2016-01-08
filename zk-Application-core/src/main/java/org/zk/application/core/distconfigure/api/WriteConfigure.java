package org.zk.application.core.distconfigure.api;

import java.util.Map;

import org.zk.application.core.exception.ZkException;
/**
 * 维护配置
 * @author shuhong.li 2015年12月23日
 *
 */
public interface WriteConfigure {
	
	boolean writeConfigure(Map<String,String> configure) throws ZkException;
	
	boolean updateConfigure(String key,String value) throws ZkException;

}
