package com.suleware.springboot.app.springboot_crud.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suleware.springboot.app.springboot_crud.entities.User;
import com.suleware.springboot.app.springboot_crud.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping()
    public ResponseEntity<User> create(@Valid @RequestBody User user, BindingResult result) {

        User newUser = userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user, BindingResult result) {

        user.setAdmin(false);
        return create(user, result);
    }

}
