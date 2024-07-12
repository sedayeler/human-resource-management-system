package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employee;
import com.example.hrms.entities.dtos.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    public final ModelMapper modelMapper;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

    @PostMapping("/register")
    public Result register(@RequestBody EmployeeDto employeeDto) throws Exception {
        return employeeService.register(employeeDto);
    }
}
