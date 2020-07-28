package com.bananApple.system.service;

import com.bananApple.system.model.SysPermission;
import com.bananApple.system.model.SysRole;
import com.bananApple.system.model.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface LoginService {

    Map<String, Object> login(HttpServletRequest request);

    UserInfo selectUserInfoByUsername(String username);
}
