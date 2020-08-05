package com.bananApple.system.controller;

import com.springBootAdmin.system.entity.SysMenu;
import com.springBootAdmin.system.entity.SysStaff;
import com.springBootAdmin.system.service.LoginService;
import com.springBootAdmin.util.CheckMobile;
import com.springBootAdmin.util.IpUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public String login () {
        return "system/login";
    }

    @RequestMapping("/mlogout")
    public String logout () {
        Session session = SecurityUtils.getSubject().getSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("sessoinId", session.getId().toString());
        loginService.updateLoginLog(map);

        return "system/login";
    }

    @RequestMapping("/system/homePage")
    public String homePage () {
        return "system/home_page";
    }

    @RequestMapping("/index")
    public String index (HttpServletRequest request, Model model) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        SysStaff user = (SysStaff) subject.getPrincipal();
        Session session = subject.getSession();
        session.setAttribute("staffId", user.getStaffId());
        session.setAttribute("staffNo", user.getStaffNo());
        session.setAttribute("username", user.getStaffNo());
        session.setAttribute("areaId", user.getAreaId());

        // 登录日志
        HashMap<String, Object> map = new HashMap<>();
        map.put("staffId", user.getStaffId());
        map.put("source", CheckMobile.check(request) ? "PHONE" : "PC");
        map.put("sessoinId", session.getId().toString());
        map.put("clientIp", IpUtils.getIpAddr(request));
        map.put("clientName", "0:0:0:0:0:0:0:1".equals(request.getRemoteHost()) ? "localhost" : request.getRemoteHost());
        map.put("serverIp", IpUtils.getServerIp());
        map.put("stateId", 1);// 登陆状态 1登录 2退出 3踢出
        loginService.addLoginLog(map);

        model.addAttribute("username", user.getStaffNo());
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
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission("/system/staff");
        return "/system/staff";
    }

    @RequestMapping("/system/department")
    public String staff_department(){
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermission("/system/department");
        return "system/staff_department";
    }
}
