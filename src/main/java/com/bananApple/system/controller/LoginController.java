package com.bananApple.system.controller;

import com.bananApple.system.service.LoginService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public String login () {
        return "/system/login";
    }

    @RequestMapping("/log")
    public String log (HttpServletRequest request) {
        Map<String, Object> result = loginService.login(request);
        if (result.get("resultCode").toString() == "200") {
            return "/system/index";
        } else {
            return "404";
        }
    }
}
