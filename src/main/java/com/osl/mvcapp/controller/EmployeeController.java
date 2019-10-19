package com.osl.mvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.osl.mvcapp.dto.EmployeeDto;
import com.osl.mvcapp.exception.EmployeeNotFoundException;
import com.osl.mvcapp.service.EmployeeService;
import com.osl.mvcapp.util.DtoFactory;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private DtoFactory employeeDtoFactory;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DtoFactory employeeDtoFactory) {
        this.employeeService = employeeService;
        this.employeeDtoFactory = employeeDtoFactory;
    }

    /**
     * @param id
     * @return Returns the person with the given id.
     */
    @RequestMapping("employee/{id}")
    @ResponseBody
    public EmployeeDto getEmployeeById(@PathVariable Integer id) {
        return employeeDtoFactory.createEmployee(employeeService.getEmployeeById(id));
    }

    // --- Error handlers

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        return e.getMessage();
    }
}
