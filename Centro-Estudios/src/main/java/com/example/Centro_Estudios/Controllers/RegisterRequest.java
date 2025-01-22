package com.example.Centro_Estudios.Controllers;

public record RegisterRequest (
    String email,
    String password,
    String firstName,
    String lastName
){}
