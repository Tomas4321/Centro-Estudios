package com.example.Centro_Estudios.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    public User() {}

}
