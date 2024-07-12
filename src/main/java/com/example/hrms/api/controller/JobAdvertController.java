package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.JobAdvertService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.dtos.JobAdvertDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobAdvert")
public class JobAdvertController {
    private final JobAdvertService jobAdvertService;

    public JobAdvertController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @PostMapping("/add")
    public Result addJobAdvert(JobAdvertDto jobAdvertDto){
        return this.jobAdvertService.addAdvert(jobAdvertDto);
    }
}
