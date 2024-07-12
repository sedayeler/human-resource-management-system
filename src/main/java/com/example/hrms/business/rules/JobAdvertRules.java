package com.example.hrms.business.rules;

import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.JobAdvertisement;
import com.example.hrms.entities.dtos.JobAdvertDto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JobAdvertRules {
    public Result createAdvert(JobAdvertDto jobAdvertDto) {
        if (jobAdvertDto.getDescription() == null || jobAdvertDto.getJob() == null || jobAdvertDto.getCity() == null ||
                jobAdvertDto.getFreePositionAmount() == null) {
            return new ErrorResult("Please fill in all required fields");
        }
        return new SuccessResult("Advert created successfully");
    }

    public boolean controlAdvert(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getPublishedDate().before(new Date())) {
            jobAdvertisement.setActive(true);
        }else{
            jobAdvertisement.setActive(false);
        }
    }
}
