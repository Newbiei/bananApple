package com.bananApple.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(useDefaultFilters = true)
public class WebAppConfig implements WebMvcConfigurer {
 
	public static void main(String[] args) {  
        SpringApplication.run(WebAppConfig.class, args);  
    }   
      
    /** 
     * 配置拦截器
     * addPathPatterns 用于添加拦截规则
     * excludePathPatterns 用户排除拦截
     * 在需要token验证的方法处加入  @Token(save=true)
     * 要进行token验证的地方加入 @Token(remove=true)
     * 并且在 对应的页面  加入  <input type="hidden" name="token" value="${token}"/>
     *
     * @author lance 
     * @param registry 
     */  
    public void addInterceptors(InterceptorRegistry registry) {  
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**");
    }  
}