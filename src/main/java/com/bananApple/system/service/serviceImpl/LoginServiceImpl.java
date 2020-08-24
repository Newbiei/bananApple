package com.bananApple.system.service.serviceImpl;

import com.bananApple.system.dao.LoginDao;
import com.bananApple.system.entity.SysMenu;
import com.bananApple.system.entity.SysRole;
import com.bananApple.system.entity.SysStaff;
import com.bananApple.system.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;

    @Override
    public SysStaff selectUserInfoByUsername(String username) {
        return loginDao.selectUserInfoByUsername(username);
    }

    @Override
    public List<SysRole> findSysRoleListByUsername(String username) {
        return loginDao.findSysRoleListByUsername(username);
    }

    @Override
    public List<SysMenu> findSysPermissionListByRoleId(String id) {
        return loginDao.findSysPermissionListByRoleId(id);
    }

    @Override
    public List<SysMenu> getMenuList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString() == null ? "" : session.getAttribute("username").toString();
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        return loginDao.getMenuList(map);
    }

    @Override
    public Integer addLoginLog(HashMap<String, Object> map) {
        return loginDao.addLoginLog(map);
    }

    @Override
    public Integer updateLoginLog(HashMap<String, Object> map) {
        return loginDao.updateLoginLog(map);
    }
}
