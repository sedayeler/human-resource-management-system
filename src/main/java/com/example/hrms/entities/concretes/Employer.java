package com.example.hrms.entities.concretes;

import com.example.hrms.entities.abstracts.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "employer_id")
public class Employer extends User {
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "web_address")
    private String webAddress;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

    public Employer() {

    }

    public Employer(int id, String email, String password, String companyName, String webAddress, String phoneNumber) {
        super(id, email, password);
        this.companyName = companyName;
        this.webAddress = webAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
