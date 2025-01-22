package com.example.Centro_Estudios.Serivices;

import com.example.Centro_Estudios.Dtos.UserDTO;
import com.example.Centro_Estudios.Entities.User;
import com.example.Centro_Estudios.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserDTO addUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), hashedPassword);
        userRepository.save(user);
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), null);
    }


}
