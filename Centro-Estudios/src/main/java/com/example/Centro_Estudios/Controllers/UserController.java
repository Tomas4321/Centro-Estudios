package com.example.Centro_Estudios.Controllers;

import com.example.Centro_Estudios.Dtos.UserDTO;
import com.example.Centro_Estudios.Entities.User;
import com.example.Centro_Estudios.Hash.PasswordHasher;
import com.example.Centro_Estudios.Serivices.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //tomas

    @CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
    @PostMapping("")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO user) {
        try {
            String hashedPassword = PasswordHasher.hashPassword(user.getPassword());
            user.setPassword(hashedPassword);
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.addUser(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Errir: No se pudo insertar el usuario}");
        }
    }

}
