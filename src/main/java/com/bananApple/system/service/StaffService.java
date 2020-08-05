package com.bananApple.system.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface StaffService {

    public String addStaff(HttpServletRequest request);

    public List<Map<String, Object>> queryStaff(HttpServletRequest request);

    public List<Map<String, Object>> getStaffById(HttpServletRequest request);

    public String updateStaff(HttpServletRequest request);

    public String updateStaffRole(HttpServletRequest request);

    public List<Map<String, Object>> queryStaffRole(String staffId);

    public String deleteStaff(HttpServletRequest request);

    public void exportStaff(HttpServletRequest request, HttpServletResponse response);
}
