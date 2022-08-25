package com.virtusa.globalexceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.exception.SqlIntegrityViolation;

@ControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(SqlIntegrityViolation.class)
	public ModelAndView exceptionHandler(SqlIntegrityViolation e) {
		ModelAndView model = new ModelAndView();
		model.addObject("error", e.getError());
		model.setViewName("errorPage");
	return model;
	}
}
