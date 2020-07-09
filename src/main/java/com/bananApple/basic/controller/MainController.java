package com.bananApple.basic.controller;

import com.bananApple.basic.service.MainService;
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

    @RequestMapping("/welcome")
    public String welcome () {
        return "welcome";
    }

    @RequestMapping("/poeCharts")
    public String poeCharts () {
        return "poeCharts";
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
}
