package org.zk.application.core.distconfigure.admin;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zk.application.core.distconfigure.impl.ZooKeeperReadConfigure;
import org.zk.application.core.distconfigure.impl.ZooKeeperWriteConfigure;

import com.alibaba.fastjson.JSON;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import org.zk.application.core.distconfigure.service.UserService;

@Controller
@RequestMapping("/admin")
public class Admin {
	static final Logger logger = Logger.getLogger(Admin.class);

	@Resource
	public ZooKeeperReadConfigure zooKeeperReadConfigure;

	@Resource
	public ZooKeeperWriteConfigure zooKeeperWriteConfigure;

	@Resource
	public UserService userService;

	@RequestMapping("/toLogin")
	public String toLogin(){

		return "toLogin";
	}
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest httpServletRequest, ModelMap map){

		return "main";
	}

	@RequestMapping("/toRegister")
	public String toRegister(){

		return "toRegister";
	}

	@RequestMapping("/register")
	public String register(){
		return null;
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
		//Map<String, String> configureMap = zooKeeperReadConfigure
		//		.readAllConfigure();
		//logger.info(configureMap.toString());
		//map.put("configureMap", configureMap);
		map.put("one", "one1");
		map.put("two", "two1");
		
		
		//freemarker调用java静态方法
		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();  
	    TemplateHashModel staticModels = wrapper.getStaticModels();  
	    TemplateHashModel fileStatics = null;
	    try {
	    	fileStatics = (TemplateHashModel) staticModels.get("org.zk.application.core.distconfigure.admin.Admin");
		} catch (TemplateModelException e) {
			e.printStackTrace();
		}
	    map.put("Admin", fileStatics);
		return "read";

	}

	public static String test(String string){
		return string;
	}
	@RequestMapping("/test")
	public void test(HttpServletRequest request,HttpServletResponse response ){
		//获取请求次数
	    String draw = "0";
	    draw = request.getParameter("draw");
	    //数据起始位置
	    String start = request.getParameter("start");
	    //数据长度
	    String length = request.getParameter("length");

		logger.info("start:"+start+"length:"+length);
	    Map<Object, Object> info = new HashMap<Object, Object>();
	    List dataList = new ArrayList();
		for (int i = 0; i < 10; i++) {
			Map dataMap = new HashMap();
			dataMap.put("name", "name"+i);
			dataMap.put("position", "position"+i);
			dataMap.put("salary", "salary"+i);
			dataMap.put("start_date","start_date"+i);
			dataMap.put("office", "office"+i);
			dataMap.put("extn", i);
			dataList.add(dataMap);
		}
	    info.put("data", dataList);
	    info.put("recordsTotal", "20");
	    info.put("recordsFiltered", 20);
	    info.put("draw", draw);	    

		
		String jsonString = JSON.toJSONString(info);
		try {
			Writer writer = response.getWriter();
			writer.write(jsonString);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
