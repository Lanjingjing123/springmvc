package com.csii.ljj.springmvc.Dao;

import com.csii.ljj.springmvc.entity.Department;
import com.csii.ljj.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap = null;
    @Autowired
    private DepartmentDao departmentDao;

    private Integer initId=1005 ;

    static{
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(1001,new Employee(1001,"E-AA","1792539263@qq.com","1",new Department(101,"D-AA")));
        employeeMap.put(1002,new Employee(1002,"E-BB","1792539263@qq.com","0",new Department(102,"D-BB")));
        employeeMap.put(1003,new Employee(1003,"E-CC","1792539263@qq.com","0",new Department(103,"D-CC")));
        employeeMap.put(1004,new Employee(1004,"E-DD","1792539263@qq.com","1",new Department(104,"D-DD")));
    }

    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employeeMap.values();
    }

    public Employee get(Integer id){
        return employeeMap.get(id);
    }

    public void delete(Integer id){
        employeeMap.remove(id);
    }
}
