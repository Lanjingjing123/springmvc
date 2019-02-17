package com.csii.ljj.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springRedirect")
@Controller
public class TestRedirect extends TestRequestMapping{

    /**
     * 重定向
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/index.jsp";
    }
}
