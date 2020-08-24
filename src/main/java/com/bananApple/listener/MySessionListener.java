package com.bananApple.listener;

import com.bananApple.system.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

/**
 * @Description:session超时或用户手动退出清除session信息，更新退出时间
 */
@Component
@WebListener
public class MySessionListener implements HttpSessionListener {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoginService loginService;

	private static MySessionListener listener;

	@PostConstruct
    public void init() {
    	listener = this;
    	listener.loginService = this.loginService;
    }
	
    @Override
    public void sessionCreated(HttpSessionEvent se) {
		logger.info("---sessionCreated----");
    	logger.info(se.getSession().getId());
    }
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.info("---sessionDestroyed----");
        //根据sessionId更新用户退出时间
		HashMap<String, Object> map = new HashMap<>();
		map.put("sessoinId", se.getSession().getId());
		listener.loginService.updateLoginLog(map);
	}

}