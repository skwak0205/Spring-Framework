package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	/*
	 * Interceptor 동작 순서
	 * 1. preHandler
	 * 2. 요청 처리 
	 * 3. postHandler
	 * 4. View 렌더링
	 * 5. afterCompletion
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("[Interceptor] : preHandle");
		
		// spring 3.2 이상부터는 servlet-context.xml에서 <exclude-mapping-path>를 통해 설정 가능
		if (
				request.getRequestURI().contains("/loginform.do") ||
				request.getRequestURI().contains("/ajaxlogin.do") ||
				request.getSession().getAttribute("login") != null ||
				request.getRequestURI().contains("/test.do")
			) {
			return true;
		}
		
		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginform.do");
		}
		
		
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("[Interceptor] : postHandle");
		
		if(modelAndView != null) {
			logger.info("Target View : " + modelAndView.getViewName());
		}		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		logger.info("[Interceptor] : afterCompletion");
	}


}
