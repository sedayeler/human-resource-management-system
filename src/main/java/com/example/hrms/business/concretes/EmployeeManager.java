package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.business.rules.EmployeeRules;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployeeDao;
import com.example.hrms.entities.concretes.Employee;
import com.example.hrms.entities.dtos.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private final EmployeeRules employeeRules;
    private final EmployeeDao employeeDao;
    private final ModelMapper modelMapper;

    public EmployeeManager(EmployeeRules employeeRules, EmployeeDao employeeDao, ModelMapper modelMapper) {
        this.employeeRules = employeeRules;
        this.employeeDao = employeeDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(employeeDao.findAll(), "List of employees");
    }

    @Override
    public Result register(EmployeeDto employeeDto) throws Exception {
        Result result = this.employeeRules.checkUser(employeeDto);
        if (result.isSuccess()) {
            Employee Employee = modelMapper.map(employeeDto, Employee.class);
            employeeDao.save(Employee);
        }
        return result;
    }
}
