package com.csii.ljj.controler;

import com.csii.ljj.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/testModel")
@Controller
public class TestModelAttribute  extends TestRequestMapping{

    /**
     * @ModelAttribute 标记的方法，会在每个目标方法执行之前被SpringMVC加载调用
     *  这里实现的效果：先从数据库（模拟）获取一个User对象的数据，然后从表单获取User对象某些属性进行Update操作
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id") Integer id, Map<String,Object> map){
        System.out.println("modelAttribute is running ");
        if(id != null){
            User user = new User("Tom",21,10);
            map.put("user",user);
        }
    }

    @RequestMapping(value = "/testModelAttr",method = RequestMethod.POST)
    public String testModelAttr(User user) {
        System.out.println(user);
        return SUCCESS;
    }
}
