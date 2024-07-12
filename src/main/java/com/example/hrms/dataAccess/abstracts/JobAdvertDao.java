package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvertisement, Integer> {

}
