package com.bananApple.shiro;

import com.bananApple.system.entity.UserInfo;
import com.bananApple.system.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
    @Autowired
    private LoginService loginService;

    // 权限授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
//        for(SysRole sysRole : loginService.findSysRoleListByUsername(userInfo.getUsername())){
//            authorizationInfo.addRole(sysRole.getRoleName());
//            logger.info(sysRole.toString());
//            for(SysPermission sysPermission : loginService.findSysPermissionListByRoleId(sysRole.getId())){
//                logger.info(sysPermission.toString());
//                authorizationInfo.addStringPermission(sysPermission.getUrl());
//            }
//        };
//        return authorizationInfo;
        return null;
    }

    // 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        logger.info("对用户[{}]进行登录验证..验证开始", username);
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = loginService.selectUserInfoByUsername(username);
        if (userInfo == null) {
            throw new UnknownAccountException("账户不存在!");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getUsername()), getName());
        return simpleAuthenticationInfo;
    }
}