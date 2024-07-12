package com.example.hrms.entities.dtos;

import com.example.hrms.entities.concretes.Job;

import java.util.Date;

public class JobAdvertDto {
    private String title;
    private String description;
    private Job job;
    private String city;
    private int minSalary;
    private int maxSalary;
    private Integer freePositionAmount;
    private Date endDate;

    public JobAdvertDto() {

    }

    public JobAdvertDto(String title, String description, Job job, String city, int minSalary, int maxSalary, int freePositionAmount, Date endDate) {
        this.title = title;
        this.description = description;
        this.job = job;
        this.city = city;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.freePositionAmount = freePositionAmount;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Integer getFreePositionAmount() {
        return freePositionAmount;
    }

    public void setFreePositionAmount(Integer freePositionAmount) {
        this.freePositionAmount = freePositionAmount;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
