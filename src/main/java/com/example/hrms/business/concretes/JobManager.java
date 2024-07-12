package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobService;
import com.example.hrms.business.rules.JobRules;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobDao;
import com.example.hrms.entities.concretes.Job;
import com.example.hrms.entities.dtos.JobDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {
    private final JobDao jobDao;
    private final ModelMapper modelMapper;
    private final JobRules jobRules;

    public JobManager(JobDao jobDao, ModelMapper modelMapper, JobRules jobRules) {
        this.jobDao = jobDao;
        this.modelMapper = modelMapper;
        this.jobRules = jobRules;
    }

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<>(this.jobDao.findAll(), "List of jobs");
    }

    @Override
    public Result add(JobDto jobDto) {
        Result result = this.jobRules.checkJob(jobDto);
        if (result.isSuccess()) {
            Job job = this.modelMapper.map(jobDto, Job.class);
            this.jobDao.save(job);
        }
        return result;
    }
}

