package com.csii.ljj.springmvc.Handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HandlerException {

//    @ExceptionHandler(ArithmeticException.class)
//    public ModelAndView handleArithmenticException(Exception ex){
//        System.out.println("出异常了"+ex);
//        String viewName = "error";
//        ModelAndView modelAndView = new ModelAndView(viewName);
//        modelAndView.addObject("exception",ex);
//        return modelAndView;
//    }

    @RequestMapping("/testHandlerException")
    public String testHandlerException(@RequestParam("i") Integer i ){
        System.out.println(10/i);
        return "success";
    }
}
