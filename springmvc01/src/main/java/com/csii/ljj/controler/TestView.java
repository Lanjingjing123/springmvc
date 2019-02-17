package com.csii.ljj.controler;

import com.csii.ljj.views.HelloView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@RequestMapping("/springView")
@Controller
public class TestView extends TestRequestMapping {
    @RequestMapping("/testMyView")
    public String testMyView() {
        System.out.println("test View");
        return "helloView";
    }
}
