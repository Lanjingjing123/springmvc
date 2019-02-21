package com.csii.ljj.springmvc.Handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandlerExceptionClass {
    @ExceptionHandler
    public ModelAndView handleArithmenticException(Exception ex){
        System.out.println("----------->出异常了"+ex);
        String viewName = "error";
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("exception",ex);
        return modelAndView;
    }
}
