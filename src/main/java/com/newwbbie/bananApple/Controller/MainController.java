package com.newwbbie.bananApple.Controller;

import com.newwbbie.bananApple.Service.MainService;
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
