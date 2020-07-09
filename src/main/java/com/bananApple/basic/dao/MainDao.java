package com.bananApple.basic.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainDao {
    String getInfo(String name);

    List getUUEInfo();
}
