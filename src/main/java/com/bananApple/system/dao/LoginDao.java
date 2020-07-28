package com.bananApple.system.dao;

import com.bananApple.system.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginDao {

    Map<String, Object> login(Map<String, Object> map);

    UserInfo selectUserInfoByUsername(String username);
}
