package com.example.hrms.entities.concretes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<JobAdvertisement> jobAdvertisements;

    public Job() {

    }

    public Job(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
