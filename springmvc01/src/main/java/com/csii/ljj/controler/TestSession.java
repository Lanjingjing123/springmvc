package com.csii.ljj.controler;

import com.csii.ljj.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;
@SessionAttributes(value = {"user"},types = User.class)
@RequestMapping("/SpringMVCsession")
@Controller
public class TestSession extends  TestRequestMapping{

    /**
     * 在@Controler上面加 @SessionAttributes(value = {"user"})，可在Session域和Request域中添加属性
     * 否则默认只在Request域中添加值
     * 可以添加类型，只存对应类型的（type属性值设置）
     * 注：注解只能放在类上，不能放在方法上
     * @param map
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object> map) {
        User user = new User("Tom",22);
        map.put("user",user);
        map.put("sex","man");
        return SUCCESS;
    }


}
