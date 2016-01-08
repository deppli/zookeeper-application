package test.ctro;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zk.application.core.distconfigure.impl.ZooKeeperReadConfigure;
import org.zk.application.core.distconfigure.impl.ZooKeeperWriteConfigure;

@Controller
public class Hello {
	static final Logger logger = Logger.getLogger(Hello.class);

	@Resource
	public ZooKeeperReadConfigure zooKeeperReadConfigure;

	@Resource
	public ZooKeeperWriteConfigure zooKeeperWriteConfigure;

	@RequestMapping("/begin")
	public String hello(ModelMap map) {
		map.put("hello", "hello");
		return "hello";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest httpServletRequest, ModelMap map) {
		String keyString = httpServletRequest.getParameter("key");
		String valueString = httpServletRequest.getParameter("value");
		Map<String, String> configure = new HashMap<String, String>();
		configure.put(keyString, valueString);
		try {
			zooKeeperWriteConfigure.writeConfigure(configure);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "hello";
	}

	@RequestMapping("/read")
	public String read(HttpServletRequest httpServletRequest, ModelMap map) {
		Map<String, String> configureMap = zooKeeperReadConfigure
				.readAllConfigure();
		logger.info(configureMap.toString());
		map.put("configureMap", configureMap);
		return "read";

	}
}
