package com.csii.ljj.controler;

import com.csii.ljj.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@SessionAttributes(value = "user",types = User.class)
@RequestMapping("/testModel")
@Controller
public class TestModelAttribute  extends TestRequestMapping{



    /**
     * @ModelAttribute 标记的方法，会在每个目标方法执行之前被SpringMVC加载调用
     *  这里实现的效果：先从数据库（模拟）获取一个User对象的数据，然后从表单获取User对象某些属性进行Update操作
     * @param id
     * @param map
//     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id") Integer id, Map<String,Object> map){
        System.out.println("modelAttribute is running ");
        System.out.println(map.getClass());
        if(id != null){
            User user = new User("Tom",21,10);
            map.put("user",user);
        }
    }

    /**
     * 执行流程：
     * 1. 执行@ModelAttribute 注解修饰的方法，从数据库（模拟）中取出对象放入Map（同时也是ModelMap,Model）里面，键为user
     * 2. SpringMVC 从Map中获取该键对应的值
     * 3. SpringMVC将该值传当参数传入目标对象
     * 注：@ModelAttribute 注解修饰的方法Map的键必须与执行的目标方法参数类型一致(User 对应 user 首字母必须小写)
     *
     *
     * SpringMVC 确定POJO类型入参的过程
     * 1. 确定一个key
     * 1）若目标方法的POJO类型的参数没有使用@ModelAttribute作为修饰，则key为POJO类名第一个字母小写
     * 2）若使用了@ModelAtrribute来修饰，则key为@ModelAttribute注解的value属性值
     * 2. 在implicitModel中查找key对应的对象，若存在，则作为入参传入
     * 1）若在@ModelAttribute标记的方法保存过，且key和1确定的一致，则会取到
     * 3. 若implicitModel 中不存在key对应的对象，则检查当前的Handler是否使用@SessionAttributes注解修饰
     * 若使用了该注解，且@SessionAttributes注解的value属性值中包含了key，则会从HttpSession中获取key所对应的value值，若存在则直接传入到目标方法的入参中，若不存在则将跑出异常。
     * 4.若Handler 没有表示@SessionAttributes注解或@SessionAttributes注解的value值不包含key，则会通过POJO类型的参数，传入不妙方法的参数
     * 5. SpringMVC会把key和value保存到implicitModel中，进而保存到request中
     *
     *
     * 源代码分析的流程
     * 1. 调用@ModelAttribute 注释修饰的方法，实际上把@ModelAttribute 方法中Map中的数据放在了implicitModel中。
     * 2.解析请求处理器的目标参数，实际上该目标参数来自于WebDataBinder对象的target属性
     * 1）.创建WebDataBinder对象
     * ①. 确定objectName属性：若传入的attrName属性值为""，则objectName为类名第一个字母小写
     *  *注意：attrName,若目标方法的POJO属性使用了@ModelAttribute来修饰，则attrName值即为@ModelAttrbute的value属性值
     *
     * ②. 确定target 属性：
     *  >在 implicitModel中查找 attrName对应的属性值，若存在，ok
     *  >*若不存在：则验证当前Handler 是否使用了@SesionAttributes进行修饰，若使用了，则尝试从Session中获取attrName所对应的属性值，若session中没有对应的属性值，则跑出了异常。
     *  >若Handler没有使用@SessionAttributes进行修饰，或@SessionAttributes中没有使用value值指定的key和
     *  attrName相匹配，则通过反射创建了POJO对象
     *
     *  2）.SpringMVC 把表单的请求参数赋给了WebDataBinder的target对应的属性。
     *  3）.*SpringMVC会把WebDataBinder的attrName和target给到implicitModel.进而传到request域对象中
     *  4）.把WebDataBinder的target作为参数传递给目标方法的入参。
     * @param user
     * @return
     */
    @RequestMapping(value = "/testModelAttr",method = RequestMethod.POST)
    public String testModelAttr(User user) {
        System.out.println(user);
        return SUCCESS;
    }
}
