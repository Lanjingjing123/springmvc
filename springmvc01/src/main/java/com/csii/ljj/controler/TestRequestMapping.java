package com.csii.ljj.controler;

import com.csii.ljj.entity.User;
import com.sun.org.apache.xpath.internal.operations.Variable;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/springmvc")
@Controller
public class TestRequestMapping {
    public static final  String SUCCESS = "success";

    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * @CookieValue(value="JSESSIONID"） 获取cookie里面的东西
     * */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value="JSESSIONID") String str) {
        System.out.println("CookieValur = "+ str);
        return SUCCESS;
    }

    /**
     * 请求头获注解获取值
     *  @RequestHeader(value = "Accept-Language")
     */

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String str) {
        System.out.println(str);
        return SUCCESS;
    }

    /**
     * 用 @RequestParam 获取url中的参数值
     *@RequestParam(value = "age",required = false,defaultValue = "10")
     * 其中 required = false 用于是否请求参数为非必输项
     * defaultValue = "10"  用于设置默认值
     * */
    @RequestMapping("/testRequestPara")
    public String testRequestPara(@RequestParam(value = "userName") String un,@RequestParam(value = "age",required = false,defaultValue = "10") int age){
        System.out.println("userName= "+ un+"age= "+ age);
        return SUCCESS;
    }

    /**
     * REST 风格的URL
     * 一CRUD为例
     * 新增： /order       POST    以前： insert?id=1
     * 修改： /order/1     PUT            update?id=1
     * 获取： /order/1     GET             select?id=1
     * 删除： /order/1     DELETE           delete?id=1
     *
     * 如何发送 PUT 和 DELETE请求呢？
     *  1. 需要配置 HiddenHttpMethodFilter 过滤器，拦截URL
     *  2. 需要发送POST请求
     *  3. 需要在发送POST请求时，携带一个name="_method"的隐藏域，值为DELETE或PUT
     *  在SpringMVC的目标方法中如何得到id呢？
     *  使用 @PathVariable 注解
     * */
    @RequestMapping(value="/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDel(@PathVariable("id") Integer id ){
        System.out.println("REST DELETE "+ id);
        return SUCCESS;
    }

    @RequestMapping(value="/testRest/{id}" , method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("RESET PUT "+ id);
        return SUCCESS;
    }

    @RequestMapping(value="/testRest",method = RequestMethod.POST)
    public String testRest(){
        System.out.println("REST POST");
        return SUCCESS;
    }

    @RequestMapping(value="/testRest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("RESET GET "+ id);
        return SUCCESS;
    }




    /**
     * @RequestMapping 支持通配符，支持占位符，为支持Reset风格具有里程碑意义
     * */
    @RequestMapping("/*/{id}")
    public String testPathVariable(@PathVariable("id") Integer id ){
        System.out.println("Id= "+ id );
        return SUCCESS;
    }

    /**
     * 使用method属性指定，请求方法
     * */
    @RequestMapping(value ="/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

    @RequestMapping("/requestMapping")
    public String requestMapping(){
        System.out.println("TestRequestMapping");
        return SUCCESS;
    }


}
