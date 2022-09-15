package com.example.codegym.controllers;

import com.example.codegym.models.dto.GetProductDto;
import com.example.codegym.models.entity.User;
import com.example.codegym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/detail/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long id) {
        Optional<User> user =userService.findUserById(id);
        return ResponseEntity.ok(user.get());

    }
}
