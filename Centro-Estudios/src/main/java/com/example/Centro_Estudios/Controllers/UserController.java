package com.example.Centro_Estudios.Controllers;

import com.example.Centro_Estudios.Dtos.UserDTO;
import com.example.Centro_Estudios.Entities.User;
import com.example.Centro_Estudios.Serivices.UserService;
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

    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody UserDTO user) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.addUser(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Errir: No se pudo insertar el usuario}");
        }
    }

}
