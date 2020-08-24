package com.bananApple.system.controller;

import com.bananApple.system.service.StaffDepartmentService;
import com.bananApple.util.MyUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班组的控制层
 */
@Controller
@RequestMapping("/staffDepartment")
public class StaffDepartmentController {
    // 注入班组的业务逻辑接口
    @Resource
    private StaffDepartmentService staffDepartmentService;

    /**
     * 首页的查询班组信息
     * @param request
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryStaffDepartment")
    public JSONObject queryStaffDepartmentController (HttpServletRequest request, Integer page, Integer rows) {
        List<HashMap> list= staffDepartmentService.selStaffDepartmentAll(request);
        return MyUtil.superPageHelper(page, rows, list);
    }

    /**
     * 点击班组首页添加按钮跳转班组添加页面
     * @return
     */
    @RequestMapping("/jumpStaffDepartmentAdd")
    public String jump_staff_department_add(){
//        String[] s = request.getParameterValues("staffTypeIdName");
//        model.addAttribute("s",s);
        return "system/staff_department_add";
    }

    /**
     * 班组添加信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/addStaffDepartment")
    public int addStaffDepartmentController(HttpServletRequest request){
        // 调用班组service中的添加班组信息方法
        int i =staffDepartmentService.addStaffDepartment(request);
        // 将结果返回给前台
        return i;
    }

    /**
     * 根据班组id删除班组信息（修改班组的状态）
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/delStaffDepartmentById")
    public int delStaffDepartmentById(HttpServletRequest request){
        // 调用班组service中的根据班组id删除班组信息（修改班组的状态）,并将结果返回给前台
        return staffDepartmentService.delStaffDepartmentById(request);
    }

    /**
     * 查询班组中所有的用户类型
     * @return
     */
    @ResponseBody
    @RequestMapping("/selStaffType")
    public List<Map<String, Object>> selStaffTypeController(){
        // 直接调用班组service中的查询班组中全部用户类型的方法,并将结果返回给前台
        return staffDepartmentService.selStaffType();
    }

    /**
     * 根据班组id查询班组信息
     * @param request
     * @return
     */
    @RequestMapping("/updDepartmentView")
    public ModelAndView updDepartmentViewController (HttpServletRequest request) {
        // 将前台的请求传给班组service中根据班组id查询班组信息方法
        List<Map<String, Object>> list = staffDepartmentService.selDepartmentById(request);
        // 创建一个视图
        ModelAndView mav = new ModelAndView("system/staff_department_upd");
        // 将查询到的集合中第一个值传给视图
        mav.addObject("list", list.get(0));
        // 返回视图
        return mav;
    }

    /**
     * 根据班组id修改班组信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/updDepartmentById")
    public int updDepartmentByIdController(HttpServletRequest request){
        // 将前台的请求传给班组service中根据班组id修改班组信息方法
        int i =staffDepartmentService.updDepartmentById(request);
        // 将修改结果返回给前台
        return i;
    }
}
