package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dtos.EmployerDto;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();

    Result register(EmployerDto employerDto);
}
