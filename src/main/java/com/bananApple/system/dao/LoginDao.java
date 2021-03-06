package com.bananApple.system.dao;

import com.bananApple.system.entity.SysMenu;
import com.bananApple.system.entity.SysRole;
import com.bananApple.system.entity.SysStaff;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface LoginDao {

    SysStaff selectUserInfoByUsername(String username);

    List<SysRole> findSysRoleListByUsername(String username);

    List<SysMenu> findSysPermissionListByRoleId(String id);

    List<SysMenu> getMenuList(Map<String, Object> map);

    Integer addLoginLog(HashMap<String, Object> map);

    Integer updateLoginLog(HashMap<String, Object> map);
}
