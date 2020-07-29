package com.bananApple.system.controller;

import com.bananApple.system.service.LoginService;
import com.bananApple.util.CipherUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/index")
    public String index () {
        return "/system/index";
    }

//    @PostMapping("/login")
//    public Object login (String username, String password, Model model) {
//        Subject user = SecurityUtils.getSubject();
//        CipherUtil cipher = new CipherUtil();
//        password = cipher.generatePassword(password);
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//
//        user.login(token);
//        return "redirect:/index";
//    }
}
