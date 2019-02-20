package com.csii.ljj.springmvc.test;

import com.csii.ljj.springmvc.Dao.EmployeeDao;
import com.csii.ljj.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Date;

@Controller
public class SpringMVCTest {
    @Autowired
    private EmployeeDao employeeDao;


    /**
     * 用于测试 @ResponseBody在方法前、
     *  和@RequestBody用于参数前
     * @return
     */
    @ResponseBody
    @RequestMapping("/testHttpMessageConvert")
    public String  testHttpMessageConvert(@RequestBody String body){
        System.out.println(body);
        return "hello"+ new Date();
    }

    /**
     *  @ResponseBody 添加此注解可解析jSon格式数据（需要添加额外pom中 关于json的三个jar包）
     * @return
     */
    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }
}
