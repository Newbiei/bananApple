package com.bananApple.basic.service.serviceImpl;

import com.bananApple.basic.service.MainService;
import com.bananApple.basic.dao.MainDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("MainService")
public class MainServiceImpl implements MainService {

    @Resource
    private MainDao mainDao;

    @Override
    public String getInfo() {
        return mainDao.getInfo();
    }

    @Override
    public List getUUEInfo() {
        return mainDao.getUUEInfo();
    }
}
