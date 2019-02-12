package com.csii.ljj.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
    /**
     * 1.使用@RequestMapping 注解来映射请求的URL
     * 2. 返回值通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下操作
     * 前缀 prefix +  retuenVal + suffix后缀
     * */
    @RequestMapping("/helloWorld")
    public String hello(){
        System.out.println("hello springmvc");
        return "success";
    }
}
