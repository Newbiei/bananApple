package com.bananApple.system.system.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班组的持久层接口
 */
@Mapper
public interface StaffDepartmentDao {
    // 首页查询全部的班组信息
    public List<HashMap> selStaffDepartmentAll(Map<String, Object> map);

    // 添加班组信息
    public int addStaffDepartment(Map<String, Object> map);

    // 根据班组id删除班组信息（修改班组的状态）
    public int delStaffDepartmentById(String departmentId);

    // 查询班组中所有的用户类型
    public List<Integer> selStaffType();

    // 根据id查询班组信息
    public List<Map<String,Object>> selDepartmentById(String departmentId);

    // 根据班组id修改班组信息
    public int updDepartmentById(Map<String, Object> map);
}
