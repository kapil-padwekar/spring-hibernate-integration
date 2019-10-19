package com.osl.mvcapp.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.osl.mvcapp.dao.EmployeeDao;
import com.osl.mvcapp.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> findEmployees() {
        return Collections.singletonList(new Employee(1, "First Emp"));
    }

}
