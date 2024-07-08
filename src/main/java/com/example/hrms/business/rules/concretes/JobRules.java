package com.example.hrms.business.rules.concretes;

import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobDao;
import com.example.hrms.entities.dtos.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRules {
    private JobDao jobDao;

    @Autowired
    public JobRules(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    public Result checkJob(JobDto jobDto) {
        if (jobDao.existsByName(jobDto.getName())) {
            return new ErrorResult("Job already exists");
        }
        return new SuccessResult("Job added");
    }
}