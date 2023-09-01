package com.seclore.main.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RequestProcessingTimeIntercepter implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		logger.info("preHandle : " + request.getRequestURI().toString() + "  start time :: " + startTime);
		request.setAttribute("start", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long endTime = System.currentTimeMillis();
		logger.info("postHandle : " + request.getRequestURI().toString() + " end time :: " + endTime);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime =  (long) request.getAttribute("start");
		long currentTime = System.currentTimeMillis();
		logger.info("afterCompletion : " + request.getRequestURI().toString() 
				+ " Total time :: " + (currentTime - startTime));
		
		
	}
}
