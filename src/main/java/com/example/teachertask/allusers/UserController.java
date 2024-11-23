package com.example.teachertask.allusers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    @PreAuthorize("hasRole('ADMIN')") //sadece ADMIN icazesi olan istifadeciler
    @PostMapping("/createUsers")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser=userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }
}
