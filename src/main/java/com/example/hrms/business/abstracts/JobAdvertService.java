package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
    Result addAdvert(JobAdvertDto jobAdvertDto);
}
