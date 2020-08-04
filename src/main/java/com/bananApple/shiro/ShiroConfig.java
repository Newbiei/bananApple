package com.bananApple.shiro;

import com.bananApple.shiro.filter.KickoutSessionControlFilter;
import com.bananApple.shiro.filter.MyFormAuthenticationFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        //拦截器
        Map<String,String> map = new LinkedHashMap<>();

        // 配置不会被拦截的链接 顺序判断
        map.put("/welcome", "anon");
        map.put("/poeCharts", "anon");
        map.put("/getUUEInfo", "anon");

        map.put("/css/**", "anon");
        map.put("/images/**", "anon");
        map.put("/js/**", "anon");
        map.put("/layuiAdmin/**", "anon");
        map.put("/layuimini/**", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        map.put("/favicon.ico","anon");
        map.put("/logout", "logout");
        // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问;
        // user:认证通过或者记住了登录状态(remeberMe)则可以通过
        map.put("/**", "authc");
        bean.setFilterChainDefinitionMap(map);

        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/403");

        //自定义拦截器
        Map<String, Filter> filters = bean.getFilters();
        filters.put("authc", new MyFormAuthenticationFilter());
        return bean;
    }

    /**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     * @return myShiroRealm
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 密码加密算法设置
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //散列的次数
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    /**
     * 安全管理器
     * @return securityManager
     */
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("myShiroRealm") MyShiroRealm myShiroRealm) {
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);
        // 注入记住我管理器
        securityManager.setRememberMeManager(rememberMeManager());
        // 注入ehCache管理器
        securityManager.setCacheManager(ehCacheManager());
        // 注入session管理器
        securityManager.setSessionManager(configWebSessionManager());
        return securityManager;
    }

    /**
     * cookie对象;
     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
     * @return rememberMeCookie
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(30*24*60*60);
        simpleCookie.setHttpOnly(true);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     * @return rememberMeManager
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /**
     * 缓存管理器
     * @return cacheManager
     */
    @Bean
    public EhCacheManager ehCacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return cacheManager;
    }

    /**
     * 会话管理器
     * @return sessionManager
     */
    @Bean
    public DefaultWebSessionManager configWebSessionManager(){
        DefaultWebSessionManager manager = new DefaultWebSessionManager();
        // 加入缓存管理器
        manager.setCacheManager(ehCacheManager());
        // 删除过期的session
        manager.setDeleteInvalidSessions(true);

        // 设置全局session超时时间
        manager.setGlobalSessionTimeout(60 * 1000);

        // 是否定时检查session
        manager.setSessionValidationSchedulerEnabled(true);
        manager.setSessionValidationScheduler(configSessionValidationScheduler());
        manager.setSessionIdUrlRewritingEnabled(false);
        manager.setSessionIdCookieEnabled(true);
        return manager;
    }

    /**
     * session会话验证调度器
     * @return session会话验证调度器
     */
    @Bean
    public ExecutorServiceSessionValidationScheduler configSessionValidationScheduler() {
        ExecutorServiceSessionValidationScheduler sessionValidationScheduler = new ExecutorServiceSessionValidationScheduler();
        //设置session的失效扫描间隔，单位为毫秒
        sessionValidationScheduler.setInterval(300 * 1000);
        return sessionValidationScheduler;
    }

    /**
     * 限制同一账号登录同时登录人数控制
     * @return 过滤器
     */
    @Bean
    public KickoutSessionControlFilter kickoutSessionControlFilter() {
        KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
        //使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户—会话之间的关系的；
        //这里我们还是用之前shiro使用的redisManager()实现的cacheManager()缓存管理
        //也可以重新另写一个，重新配置缓存时间之类的自定义缓存属性
        kickoutSessionControlFilter.setCacheManager(ehCacheManager());
        //用于根据会话ID，获取会话进行踢出操作的；
        kickoutSessionControlFilter.setSessionManager(configWebSessionManager());
        //是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；踢出顺序。
        kickoutSessionControlFilter.setKickoutAfter(false);
        //同一个用户最大的会话数，默认1；比如2的意思是同一个用户允许最多同时两个人登录；
        kickoutSessionControlFilter.setMaxSession(1);

        //被踢出后重定向到的地址；
        kickoutSessionControlFilter.setKickoutUrl("/login");
        return kickoutSessionControlFilter;
    }
}