package com.ruda.s4.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	

	//Controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//true : Controller로 전송
		//false: Controller로 전송 X
		
		boolean result = false;
		Object obj = request.getSession().getAttribute("member");
		
		if(obj !=null) {
			result = true;
			
		}else {
			response.sendRedirect("../member/memberLogin");
		}
		
		
		return result;
	}


	
	
	
}
