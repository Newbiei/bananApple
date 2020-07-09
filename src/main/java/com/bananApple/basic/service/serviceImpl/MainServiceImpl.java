package com.bananApple.basic.service.serviceImpl;

import com.bananApple.basic.service.MainService;
import com.bananApple.basic.dao.MainDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("MainService")
public class MainServiceImpl implements MainService {

    @Resource
    private MainDao mainDao;

    @Override
    public String getInfo(HttpServletRequest request) {
        String name = request.getParameter("name") == null ? "" : request.getParameter("name");
        return mainDao.getInfo(name);
    }

    @Override
    public List getUUEInfo() {
        return mainDao.getUUEInfo();
    }
}
