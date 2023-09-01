package com.seclore.main.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class EmployeeCRUDExceptionHandler {

	Logger logger = LoggerFactory.getLogger(getClass());

	public EmployeeCRUDExceptionHandler() {
		logger.info("EmployeeCRUDExceptionHandler object created!");
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView getExceptionPage(Exception exception) {
		logger.info("getExceptionPage() called");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("err", exception.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
