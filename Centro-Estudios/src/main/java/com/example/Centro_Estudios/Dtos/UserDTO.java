package com.example.Centro_Estudios.Dtos;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // Constructor vacío
    public UserDTO() {}

    // Constructor con argumentos
    public UserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters y Setters
    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }
}
