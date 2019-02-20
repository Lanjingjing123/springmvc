package com.csii.ljj.springmvc.Handler;

import com.csii.ljj.springmvc.Dao.DepartmentDao;
import com.csii.ljj.springmvc.Dao.EmployeeDao;
import com.csii.ljj.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EmployeeHandler {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false) Integer id,
        Map<String,Object> map){
        if(id != null){
            map.put("employee",employeeDao.get(id));
        }
    }

    @RequestMapping(value = "emp",method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value="/emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id,Map<String,Object> map){
        map.put("employee",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());
        return "input";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String input(Map<String,Object> map) {
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }


    /**
     * 利用@param bindingResult 这个参数用于表单和bean类型转换失败的储存
     * @param employee
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(Employee employee, BindingResult bindingResult) {
        System.out.println("save:"+employee);
        if(bindingResult.getErrorCount()>0){//数据类型转换失败信息
            System.out.println("出错了！！！");
            for (FieldError error:bindingResult.getFieldErrors()) {
                System.out.println(error.getField()+":"+error.getDefaultMessage());
            }
        }
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value ="/emps")
    public String list(Map<String,Object> map) {
        map.put("employees",employeeDao.getAll());
        return "list";
    }

    /**
     * 初始化数据绑定
     * @param binder
     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.setDisallowedFields("lastName");
//    }
}
