package com.bananApple.shiro.filter;

import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    private static final Logger logger = LoggerFactory.getLogger(MyFormAuthenticationFilter.class);
    /**
     * 重写该方法, 判断返回登录信息
     */
    @Override
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        String className = ae.getClass().getName();
        String message;
        String userName = getUsername(request);
        if (UnknownAccountException.class.getName().equals(className)) {
            logger.info("对用户[{}]进行登录验证..验证未通过,未知账户", userName);
            message = "账户不存在";
        } else if (IncorrectCredentialsException.class.getName().equals(className)) {
            logger.info("对用户[{}]进行登录验证..验证未通过,密码不正确", userName);
            message = "密码不正确";
        } else if(LockedAccountException.class.getName().equals(className)) {
            logger.info("对用户[{}]进行登录验证..验证未通过,账户已锁定", userName);
            message = "账户已锁定";
        } else if(ExcessiveAttemptsException.class.getName().equals(className)) {
            logger.info("对用户[{}]进行登录验证..验证未通过,错误次数过多", userName);
            message = "用户名或密码错误次数过多，请十分钟后再试";
        } else if (AuthenticationException.class.getName().equals(className)) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[{}]进行登录验证..验证未通过,未知错误", userName);
            message = "用户名或密码不正确";
        } else{
            message = className;
        }
        request.setAttribute(getFailureKeyAttribute(), message);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        // 1.获取sesssion
        Session session = subject.getSession(false);
        if (session != null) {
            // 清除shiro共享的上一次地址 ://shiroSavedRequest
            session.removeAttribute(WebUtils.SAVED_REQUEST_KEY);
        }

        return super.onLoginSuccess(token, subject, request, response);
    }
}