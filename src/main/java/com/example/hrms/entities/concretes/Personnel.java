package com.example.hrms.entities.concretes;

import com.example.hrms.entities.abstracts.User;
import jakarta.persistence.*;

@Entity
@Table(name = "personnels")
@PrimaryKeyJoinColumn(name = "personnel_id")
public class Personnel extends User {
    public Personnel() {

    }

    public Personnel(int id, String email, String password) {
        super(id, email, password);
    }
}
