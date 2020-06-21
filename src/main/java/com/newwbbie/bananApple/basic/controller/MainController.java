package com.newwbbie.bananApple.basic.controller;

import com.newwbbie.bananApple.basic.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class MainController {

    @Resource
    private MainService mainService;

    @RequestMapping("/welcome")
    public String welcome () {
        return "welcome";
    }
}
