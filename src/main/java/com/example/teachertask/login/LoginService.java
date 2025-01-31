package com.example.teachertask.login;

import com.example.teachertask.allusers.User;
import com.example.teachertask.allusers.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> loginUser(LoginDTO loginDTO) {
        return Optional.ofNullable(userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword()));
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
