package com.bananApple.system.service.serviceImpl;

import com.bananApple.system.dao.LoginDao;
import com.bananApple.system.entity.UserInfo;
import com.bananApple.system.service.LoginService;
import com.bananApple.util.CipherUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;

    @Override
    public Map<String, Object> login(HttpServletRequest request) {
        String username = request.getParameter("username") == null ? "" : request.getParameter("username");
        String password = request.getParameter("password") == null ? "" : request.getParameter("password");
        Map<String, Object> map = new HashMap<>();
        CipherUtil cipher = new CipherUtil();
        password = cipher.generatePassword(password);
        map.put("username", username);
        map.put("password", password);
        Map<String, Object> loginResult = loginDao.login(map);

        Map<String, Object> result = new HashMap<>();
        HttpSession session = request.getSession();
        if (loginResult != null && loginResult.size() > 0) {
            result.put("resultCode", 200);
            session.setAttribute("staffId", String.valueOf(loginResult.get("staff_id")));
            session.setAttribute("staffNo", String.valueOf(loginResult.get("staff_no")));
            session.setAttribute("staffName", String.valueOf(loginResult.get("staff_name")));
            session.setAttribute("areaId", String.valueOf(loginResult.get("area_id")));
        } else {
            result.put("resultCode", 404);
        }
        return result;
    }

    @Override
    public UserInfo selectUserInfoByUsername(String username) {
        return loginDao.selectUserInfoByUsername(username);
    }
}
