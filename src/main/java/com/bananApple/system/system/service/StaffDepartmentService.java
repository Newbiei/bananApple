package com.bananApple.system.system.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班组的业务逻辑接口
 */
public interface StaffDepartmentService {
    // 首页查询全部的班组信息
    public List<HashMap> selStaffDepartmentAll(HttpServletRequest request);

    // 添加班组信息
    public int addStaffDepartment(HttpServletRequest request);

    // 根据班组id删除班组信息（修改班组的状态）
    public int delStaffDepartmentById(HttpServletRequest request);

    // 查询班组中所有的用户类型
    public List<Map<String, Object>> selStaffType();

    // 根据id查询班组信息
    public List<Map<String,Object>> selDepartmentById(HttpServletRequest request);

    // 根据班组id修改班组信息
    public int updDepartmentById(HttpServletRequest request);
}
