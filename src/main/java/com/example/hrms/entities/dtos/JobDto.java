package com.example.hrms.entities.dtos;

public class JobDto {
    private String name;

    public JobDto() {

    }

    public JobDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
