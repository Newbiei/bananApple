package com.newwbbie.bananApple.basic.service.serviceImpl;

import com.newwbbie.bananApple.basic.dao.MainDao;
import com.newwbbie.bananApple.basic.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("MainService")
public class MainServiceImpl implements MainService {

    @Resource
    private MainDao mainDao;

    @Override
    public String getInfo() {
        return mainDao.getInfo();
    }
}
