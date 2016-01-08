package org.zk.application.core.distconfigure.api;

import java.util.Map;
/**
 * 获取配置
 * @author shuhong.li 2015年12月23日
 *
 */
public interface ReadConfigure {

	Map<String,String> readAllConfigure();
	
	String readConfigure(String key);
}
