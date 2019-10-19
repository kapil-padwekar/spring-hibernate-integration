package com.osl.mvcapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osl.mvcapp.dao.EmployeeDao;
import com.osl.mvcapp.model.Employee;
import com.osl.mvcapp.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return null;
    }

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findEmployees();
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {

    }

}
