package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
    boolean existsByEmail(String email);
}
