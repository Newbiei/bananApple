package com.bananApple.basic.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainDao {
    String getInfo();
}
