package com.example.hrms.business.rules.concretes;

import com.example.hrms.business.verification.abstracts.EmailVerificationService;
import com.example.hrms.business.verification.abstracts.EmployeeCheckService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployeeDao;
import com.example.hrms.entities.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRules {
    private EmployeeDao employeeDao;
    private EmployeeCheckService employeeCheckService;
    private EmailVerificationService emailVerificationService;

    @Autowired
    public EmployeeRules(EmployeeDao employeeDao, EmployeeCheckService employeeCheckService, EmailVerificationService emailVerificationService) {
        this.employeeDao = employeeDao;
        this.employeeCheckService = employeeCheckService;
        this.emailVerificationService = emailVerificationService;
    }

    public Result checkUser(EmployeeDto employeeDto) throws Exception {
        if (employeeDto.getFirstName() == null || employeeDto.getLastName() == null || employeeDto.getNationalityId() == null || employeeDto.getDateOfBirthYear() == null || employeeDto.getEmail() == null || employeeDto.getPassword() == null) {
            return new ErrorResult("You are required to fill out all the fields");
        }
        if (!employeeDto.getPassword().equals(employeeDto.getConfirmPassword())) {
            return new ErrorResult("Passwords don't match");
        }
        if (employeeDao.existsByNationalityId(employeeDto.getNationalityId())) {
            return new ErrorResult("Nationality already exists");
        }
        if (employeeDao.existsByEmail(employeeDto.getEmail())) {
            return new ErrorResult("Email already exists");
        }
        if (!employeeCheckService.isRealPerson(employeeDto)) {
            return new ErrorResult("Identity verification failed");
        }
        if (!emailVerificationService.isEmailValid(employeeDto.getEmail())) {
            return new ErrorResult("Email is not valid");
        }
        return new SuccessResult("Registration is successfull");
    }
}
