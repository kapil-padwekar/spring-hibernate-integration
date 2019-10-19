package com.osl.mvcapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osl.mvcapp.model.Employee;
import com.osl.mvcapp.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee getEmployeeById(Integer id) {
        return null;
    }

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public List<Employee> findAllEmployees() {
        return null;
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {

    }

}
