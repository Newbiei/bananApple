package com.bananApple.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Token拦截器，防止用户重复提交数据
 * 
 */
public class TokenInterceptor extends HandlerInterceptorAdapter
{

	private Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		if (handler instanceof HandlerMethod)
		{
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Token annotation = method.getAnnotation(Token.class);
			if (annotation != null)
			{
				boolean needSaveSession = annotation.save();
				if (needSaveSession)
				{
					request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
				}
				boolean needRemoveSession = annotation.remove();
				if (needRemoveSession)
				{
					if (isRepeatSubmit(request))
					{
						request.getSession(false).removeAttribute("token");
						
					}else{
						request.setAttribute("repeatSubmit", "请勿重复提交");
						logger.info("请勿重复提交，url：" + request.getServletPath());
						return false;
					}
				}
			}
			return true;
		}
		else
		{
			return super.preHandle(request, response, handler);
		}
	}

	private boolean isRepeatSubmit(HttpServletRequest request)
	{
		String serverToken = (String) request.getSession(false).getAttribute("token");
		if (serverToken == null) { return true; }
		String clinetToken = request.getHeader("token");
		if (clinetToken == null) { return true; }
		if (!serverToken.equals(clinetToken)) { return true; }
		return false;
	}
}