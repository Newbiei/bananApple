package com.bananApple.system.controller;

import com.bananApple.system.entity.SysMenu;
import com.bananApple.system.entity.UserInfo;
import com.bananApple.system.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("/system")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public String login () {
        return "system/login";
    }

    @RequestMapping("/index")
    public String index (Model model) {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());

        model.addAttribute("username", user.getUsername());
        return "system/index";
    }

    /**
     * 获取首页菜单
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMenuList")
    public List<SysMenu> getMenuList (HttpServletRequest request) {
        return loginService.getMenuList(request);
    }

    @RequestMapping("/system/staff")
    public String staff () {
        return "system/staff";
    }
}
