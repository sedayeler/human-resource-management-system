package com.example.hrms.business.rules;

import com.example.hrms.business.verification.abstracts.EmailVerificationService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.dtos.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerRules {
    private final EmployerDao employerDao;
    private final EmailVerificationService emailVerificationService;

    public EmployerRules(EmployerDao employerDao, EmailVerificationService emailVerificationService) {
        this.employerDao = employerDao;
        this.emailVerificationService = emailVerificationService;
    }

    public Result checkUser(EmployerDto employerDto) {
        if(employerDto.getCompanyName() == null || employerDto.getWebAddress() == null || employerDto.getPhoneNumber() == null || employerDto.getEmail() == null || employerDto.getPassword() == null || employerDto.getConfirmPassword() == null){
            return new ErrorResult("You are required to fill out all the fields");
        }if(!employerDto.getPassword().equals(employerDto.getConfirmPassword())){
            return new ErrorResult("Passwords don't match");
        }if(employerDao.existsByEmail(employerDto.getEmail())){
            return new ErrorResult("Email already exists");
        }if(!emailVerificationService.isEmailValid(employerDto.getEmail())){
            return new ErrorResult("Email is not valid");
        }
        return new SuccessResult("Registration is successfull");
    }
}
