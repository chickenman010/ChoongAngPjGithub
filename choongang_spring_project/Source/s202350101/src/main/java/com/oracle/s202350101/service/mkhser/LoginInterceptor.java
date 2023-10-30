package com.oracle.s202350101.service.mkhser;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	public LoginInterceptor() {
		// TODO Auto-generated constructor stub
	}
	
	// 3번째 실행
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response, 
						   Object handler,
						   ModelAndView modelAndView) throws Exception {
		System.out.println("post handle....................................");
		String user_id = (String) modelAndView.getModel().get("user_id");
		int userIdCnt = (Integer) modelAndView.getModel().get("userIdCnt");
		int userPwCnt = (Integer) modelAndView.getModel().get("userPwCnt");
		System.out.println("LoginInterceptor post handle userIdCnt: " + userIdCnt);
		System.out.println("LoginInterceptor post handle userPwCnt: " + userPwCnt);
		// User가 존재하지 않으면
		if(userIdCnt < 1) {
			System.out.println("userIdCnt Not exists");
		//	response.sendRedirect("user_login");
		//  아이디 또는 비밀번호를 잘못 입력했습니다.
		//	입력하신 내용을 다시 확인해주세요.
		} else if(userPwCnt < 1) {
			System.out.println("userPwCnt Not exists");
			response.sendRedirect("user_login");
		} else {	// 정상 Login User
			System.out.println("userIdCnt & userPwCnt exists");
			request.getSession().setAttribute("user_id", user_id);
			response.sendRedirect("main");
		}

	}
	
	// 1번째 실행
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler) throws Exception {
		System.out.println("pre handle....................................");
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		System.out.println("Bean: " + method.getBean());
		System.out.println("Method: " + methodObj);
		
		return true;
	}
	
}
