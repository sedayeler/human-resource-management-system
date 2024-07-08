package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Job;
import com.example.hrms.entities.dtos.JobDto;

import java.util.List;

public interface JobService {
    DataResult<List<Job>> getAll();

    Result add(JobDto jobDto);
}
