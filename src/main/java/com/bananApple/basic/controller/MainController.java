package com.bananApple.basic.controller;

import com.bananApple.basic.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class MainController {

    @Resource
    private MainService mainService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/welcome")
    public String welcome () {
        return "welcome";
    }

    @RequestMapping("/poeCharts")
    public String poeCharts () {
        return "poeCharts";
    }

    @RequestMapping("/markdown")
    public String markdown () {
        return "markdown";
    }

    @ResponseBody
    @RequestMapping("/getInfo")
    public String getInfo (HttpServletRequest request) {
        return mainService.getInfo(request);
    }

    @ResponseBody
    @RequestMapping("/getUUEInfo")
    public List getUUEInfo () {
        List list = mainService.getUUEInfo();
        return list;
    }

    @ResponseBody
    @RequestMapping("/sendEmail")
    public String sendEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("1098160709@qq.com"); // 接收地址,可传入数组进行群发
            message.setSubject("测试标题"); // 标题
            message.setText("测试内容\n这是第二行"); // 内容
            javaMailSender.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
