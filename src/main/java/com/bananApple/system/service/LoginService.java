package com.bananApple.system.service;

import com.bananApple.system.entity.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface LoginService {

    Map<String, Object> login(HttpServletRequest request);

    UserInfo selectUserInfoByUsername(String username);
}
