package com.bananApple.annotation;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SaveOperateLog {

	Class<?> request() default HttpServletRequest.class; // 请求体

	String menu() default ""; // 操作菜单

	int operateType();// 操作类型

}