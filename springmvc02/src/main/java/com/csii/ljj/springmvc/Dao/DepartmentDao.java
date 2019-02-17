package com.csii.ljj.springmvc.Dao;

import com.csii.ljj.springmvc.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer,Department> departmentMap = null;

    static{
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(101,new Department(101,"D-AA"));
        departmentMap.put(102,new Department(102,"D-BB"));
        departmentMap.put(103,new Department(103,"D-CC"));
        departmentMap.put(104,new Department(104,"D-DD"));
        departmentMap.put(105,new Department(105,"D-EE"));
    }

    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }

    public Department getDepartment(Integer id){
        return departmentMap.get(id);
    }
}
