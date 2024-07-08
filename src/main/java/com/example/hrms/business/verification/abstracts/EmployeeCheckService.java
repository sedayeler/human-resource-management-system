package com.example.hrms.business.verification.abstracts;

import com.example.hrms.entities.dtos.EmployeeDto;

public interface EmployeeCheckService {
    boolean isRealPerson(EmployeeDto employeeDto) throws Exception;
}
