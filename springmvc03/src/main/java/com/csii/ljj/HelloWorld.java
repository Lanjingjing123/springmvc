package com.csii.ljj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
    @RequestMapping("/testHelloWorld")
    public String testHelloWorld(){
        return "success";
    }

    public HelloWorld(){
        System.out.println("construct HelloWorld!");
    }
}
