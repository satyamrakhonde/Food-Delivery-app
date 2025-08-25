package com.fooddelivery.UserService.controller;

import com.fooddelivery.UserService.dto.UserDTO;
import com.fooddelivery.UserService.entity.Users;
import com.fooddelivery.UserService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    public Users create(@RequestBody Users req) {
        if(userRepository.existsById(req.getId())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Id already exists");
        }
        return userRepository.save(req);
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
}
