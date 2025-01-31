package com.example.teachertask.login;

import com.example.teachertask.allusers.User;
import com.example.teachertask.jwt.JwtTokenUtil;
import com.example.teachertask.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    private final LoginService loginService;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public LoginController(LoginService loginService, JwtTokenUtil jwtTokenUtil) {
        this.loginService = loginService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public Map<String, Object> loginUser(@RequestBody LoginDTO loginDTO) {
        Optional<User> userOptional = loginService.loginUser(loginDTO);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String token = jwtTokenUtil.generateToken(user.getEmail(), Role.valueOf(user.getRole()));

            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("token", token);

            return response;
        } else {
            throw new RuntimeException("Email və ya şifrə səhvdir");
        }
    }
}
