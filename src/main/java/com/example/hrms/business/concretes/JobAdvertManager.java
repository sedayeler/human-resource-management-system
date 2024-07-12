package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobAdvertService;
import com.example.hrms.business.rules.JobAdvertRules;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobAdvertDao;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.JobAdvertDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class JobAdvertManager implements JobAdvertService {
    private final JobAdvertDao jobAdvertDao;
    private final JobAdvertRules jobAdvertRules;
    private final ModelMapper modelMapper;

    public JobAdvertManager(JobAdvertDao jobAdvertDao, JobAdvertRules jobAdvertRules, ModelMapper modelMapper) {
        this.jobAdvertDao = jobAdvertDao;
        this.jobAdvertRules = jobAdvertRules;
        this.modelMapper = modelMapper;
    }

    public Result addAdvert(JobAdvertDto jobAdvertDto) {
        Result result = jobAdvertRules.createAdvert(jobAdvertDto);
        if (result.isSuccess()) {
            JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertDto, JobAdvertisement.class);
            this.jobAdvertDao.save(jobAdvertisement);
        }
        return result;
    }
}
