package com.bananApple.system.controller;

import com.bananApple.annotation.SaveOperateLog;
import com.bananApple.system.service.StaffService;
import com.bananApple.util.Constants;
import com.bananApple.util.MyUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("staff")
public class StaffController {

    @Resource
    private StaffService staffService;

    @ResponseBody
    @RequestMapping("queryStaff")
    @SaveOperateLog(menu = "人员管理", operateType = Constants.PubOperateType.QUERY)
    public JSONObject queryStaff (HttpServletRequest request, Integer page, Integer rows) {
        List<Map<String, Object>> list = staffService.queryStaff(request);
        return MyUtil.superPageHelper(page, rows, list);
    }

    @RequestMapping("add")
    public String add (Model model) {
        Session session = SecurityUtils.getSubject().getSession();
        model.addAttribute("areaId", session.getAttribute("areaId"));
        return "system/staff_add";
    }


}
