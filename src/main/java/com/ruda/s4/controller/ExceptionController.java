package com.ruda.s4.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice  //예외처리를 하는 컨트롤러를 만드는 Annotation
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView getNull() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/common_500_error");
		return mv;
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView getNumber() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/common_500_error");
		return mv;
	}
	
}
