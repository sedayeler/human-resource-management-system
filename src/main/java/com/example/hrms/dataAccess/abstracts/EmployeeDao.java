package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    boolean existsByNationalityId(String nationalityId);

    boolean existsByEmail(String email);
}
