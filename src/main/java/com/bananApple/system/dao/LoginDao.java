package com.bananApple.system.dao;

import com.bananApple.system.entity.SysMenu;
import com.bananApple.system.entity.SysRole;
import com.bananApple.system.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginDao {

    UserInfo selectUserInfoByUsername(String username);

    List<SysRole> findSysRoleListByUsername(String username);

    List<SysMenu> findSysPermissionListByRoleId(String id);

    List<SysMenu> getMenuList(Map<String, Object> map);
}
