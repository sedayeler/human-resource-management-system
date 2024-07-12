package com.example.hrms.entities.concretes;

import com.example.hrms.entities.abstracts.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends User {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "nationality_id")
    private String nationalityId;
    @Column(name = "date_of_birth_year")
    private Integer dateOfBirthYear;

    @OneToMany(mappedBy = "employee")
    private List<JobAdvertisement> jobAdvertisements;

    public Employee() {

    }

    public Employee(int id, String email, String password, String firstName, String lastName, String nationalityId, Integer dateOfBirthYear) {
        super(id, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalityId = nationalityId;
        this.dateOfBirthYear = dateOfBirthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public Integer getDateOfBirthYear() {
        return dateOfBirthYear;
    }

    public void setDateOfBirthYear(Integer dateOfBirthYear) {
        this.dateOfBirthYear = dateOfBirthYear;
    }
}

