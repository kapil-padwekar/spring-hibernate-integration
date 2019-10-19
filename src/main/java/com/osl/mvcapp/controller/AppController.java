package com.osl.mvcapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osl.mvcapp.model.Employee;
import com.osl.mvcapp.service.EmployeeService;

@Controller
@RequestMapping(value = "api")
public class AppController {

    @Autowired
    EmployeeService service;

    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public @ResponseBody List<Employee> listEmployees() {

        List<Employee> employees = service.findAllEmployees();
        return employees;
    }

}