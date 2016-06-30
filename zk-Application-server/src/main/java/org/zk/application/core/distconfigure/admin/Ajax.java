package org.zk.application.core.distconfigure.admin;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zk.application.core.distconfigure.constants.Constants;
import org.zk.application.core.distconfigure.dict.Dict;
import org.zk.application.core.distconfigure.pojo.User;
import org.zk.application.core.distconfigure.service.UserService;
import org.zk.application.core.distconfigure.uitl.Util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lishuhong on 16/6/16.
 */
@Controller
@RequestMapping("/ajax")
public class Ajax {

    @Resource
    private UserService userService;

    @RequestMapping("/checkEmail")
    public void loadUserByLoginName(@RequestParam("email") String loginName, HttpServletResponse httpServletResponse) throws Exception {
        String flag = Dict.TRUE;
        User user = userService.loadUserByLoginName(loginName);
        if (user != null) {
            flag = Dict.FALSE;
        }
        Map<String,String> result = new HashMap<String, String>();
        result.put(Dict.FLAG,flag);
        String jsonResult = JSON.toJSONString(result);
        httpServletResponse.getWriter().write(jsonResult);
    }

    @RequestMapping("/register")
    public void register(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{
        Map<String,String> result =  new HashMap<String, String>();
        String email = httpServletRequest.getParameter(Dict.EMAIL);
        String passwd = httpServletRequest.getParameter(Dict.PASSWD);
        String repasswd = httpServletRequest.getParameter(Dict.REPASSWD);
        if (StringUtils.isEmpty(email)||StringUtils.isEmpty(passwd)
                ||StringUtils.isEmpty(repasswd)||!passwd.equals(repasswd)) {
            result.put("status","500");
            result.put("errorMsg", Constants.PARAMETER_ERROR);
            httpServletResponse.getWriter().write(JSON.toJSONString(result));
            return;
        }
        User queryUser = userService.loadUserByLoginName(email);
        if (queryUser != null) {
            result.put("status","500");
            result.put("errorMsg", Constants.USER_ALREADYEXISTED);
            httpServletResponse.getWriter().write(JSON.toJSONString(result));
            return;
        }
        User user =  new User();
        user.setLoginName(email);
        user.setLoginPasswd(Util.EncoderByMd5(passwd));
        try {
            int addResult = userService.addUser(user);
        }catch (Exception exception) {
            
        }


    }
}
