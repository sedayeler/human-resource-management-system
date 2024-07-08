package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employee;
import com.example.hrms.entities.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();

    Result register(EmployeeDto employeeDto) throws Exception;
}
