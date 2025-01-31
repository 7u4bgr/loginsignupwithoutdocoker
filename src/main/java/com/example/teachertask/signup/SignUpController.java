package com.example.teachertask.signup;

import com.example.teachertask.allusers.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class SignUpController {
    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }


    @PostMapping("/signup")
    public User signUpDTO(@RequestBody SignUpDTO signUpDTO) {
        return signUpService.saveSignUpData(signUpDTO);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addadmin")
    public User addAdmin(@RequestBody SignUpDTO signUpDTO) {
        return signUpService.addAdmin(signUpDTO);
    }
}

