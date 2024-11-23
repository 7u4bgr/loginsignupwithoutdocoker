package com.example.teachertask.login;

import com.example.teachertask.allusers.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController

public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

//    @Cacheable(value = "login", key = "id")
    @PostMapping("/login")
    public User loginUser(@RequestBody LoginDTO loginDTO) {
        return loginService.loginUser(loginDTO);
    }
}
