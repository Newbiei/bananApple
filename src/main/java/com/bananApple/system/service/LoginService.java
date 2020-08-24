package com.bananApple.system.service;

import com.bananApple.system.entity.SysMenu;
import com.bananApple.system.entity.SysRole;
import com.bananApple.system.entity.SysStaff;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public interface LoginService {

    /**
     * 通过用户名查找用户
     */
    SysStaff selectUserInfoByUsername(String username);

    /**
     * 通过用户名查找角色列表
     */
    List<SysRole> findSysRoleListByUsername(String username);

    /**
     * 查找某角色的权限列表
     */
    List<SysMenu> findSysPermissionListByRoleId(String id);

    /**
     * 获取首页菜单
     * @param request
     * @return
     */
    List<SysMenu> getMenuList(HttpServletRequest request);

    /**
     * 登录日志
     * @param map
     * @return
     */
    Integer addLoginLog(HashMap<String, Object> map);

    /**
     * 登出日志
     * @param map
     * @return
     */
    Integer updateLoginLog(HashMap<String, Object> map);
}
