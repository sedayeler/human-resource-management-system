package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.rules.EmployerRules;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dtos.EmployerDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private final EmployerDao employerDao;
    private final EmployerRules employerRules;
    private final ModelMapper modelMapper;

    public EmployerManager(EmployerDao employerDao, EmployerRules employerRules, ModelMapper modelMapper) {
        this.employerDao = employerDao;
        this.employerRules = employerRules;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerDao.findAll(), "List of employer");
    }

    @Override
    public Result register(EmployerDto employerDto) {
        Result result = this.employerRules.checkUser(employerDto);
        if (result.isSuccess()) {
            Employer employer = this.modelMapper.map(employerDto, Employer.class);
            this.employerDao.save(employer);
        }
        return result;
    }
}
