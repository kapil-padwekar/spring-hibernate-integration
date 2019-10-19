package com.osl.mvcapp.service;

import java.util.List;

import com.osl.mvcapp.model.Employee;

public interface EmployeeService {

    /**
     * @param id
     * @return Returns the Employee with the given id.
     */
    public Employee getEmployeeById(Integer id);

    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);
}
