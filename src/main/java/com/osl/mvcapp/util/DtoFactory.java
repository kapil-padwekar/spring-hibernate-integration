package com.osl.mvcapp.util;

import org.springframework.stereotype.Component;

import com.osl.mvcapp.dto.EmployeeDto;
import com.osl.mvcapp.model.Employee;

/**
 * Factory methods for creating DTOs.
 * 
 */
@Component
public class DtoFactory {

    public EmployeeDto createEmployee(Employee domain) {

        EmployeeDto dto = new EmployeeDto();
        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setSalary(domain.getSalary());
        dto.setSsn(domain.getSsn());
        dto.setJoiningDate(domain.getJoiningDate());
        return dto;
    }

}
