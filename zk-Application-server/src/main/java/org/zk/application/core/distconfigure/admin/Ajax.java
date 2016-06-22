package org.zk.application.core.distconfigure.admin;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zk.application.core.distconfigure.pojo.User;
import org.zk.application.core.distconfigure.service.UserService;

import javax.annotation.Resource;
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

    @RequestMapping("/loadUserByLoginName")
    public void loadUserByLoginName(@RequestParam("email") String loginName, HttpServletResponse httpServletResponse) throws IOException {
        String flag = "true";
        User user = userService.loadUserByLoginName(loginName);
        if (user != null) {
            flag = "false";
        }
        Map<String,String> result = new HashMap<String, String>();
        result.put("flag",flag);
        String jsonResult = JSON.toJSONString(result);
        httpServletResponse.getWriter().write(jsonResult);
    }
}
