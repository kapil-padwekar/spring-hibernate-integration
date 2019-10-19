package com.osl.mvcapp.dao;

import java.util.List;

import com.osl.mvcapp.model.Employee;

public interface EmployeeDao {

    public List<Employee> findEmployees();
}
