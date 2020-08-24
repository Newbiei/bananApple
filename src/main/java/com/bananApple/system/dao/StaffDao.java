package com.bananApple.system.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StaffDao {

    int addStaff(Map<String, Object> map);

    List<Map<String, Object>> queryStaff(Map<String, Object> map);

    List<Map<String, Object>> getStaffById(String staffId);

    int updateStaff(Map<String, Object> map);

    int updateStaffRole(Map<String, Object> map);

    List<Map<String, Object>> queryStaffRole(String staffId);

    void deleteStaffRole(String staffId);

    void addStaffRole(Map<String, Object> map);

    int deleteStaff(Map<String, Object> map);
}
