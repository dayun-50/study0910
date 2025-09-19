package com.kedu.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginValidator implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String loginID = (String) request.getSession().getAttribute("loginID");
		
		if(loginID != null) {
			return true;
		}
		response.sendRedirect("/error");
		return false;
		
	}
}
