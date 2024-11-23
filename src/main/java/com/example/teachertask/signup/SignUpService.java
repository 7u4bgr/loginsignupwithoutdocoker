package com.example.teachertask.signup;

import com.example.teachertask.allusers.User;
import com.example.teachertask.allusers.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService {

    private final UserRepository userRepository;


    public SignUpService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Transactional

    public User saveSignUpData(SignUpDTO signUpDTO) {
        String password = signUpDTO.getPassword();
        User users=new User();
        users.setOrganizationName(signUpDTO.getOrganizationName());
        users.setUserName(signUpDTO.getUserName());
        users.setPhoneNumber(signUpDTO.getPhoneNumber());
        users.setEmail(signUpDTO.getEmail());
        users.setPassword(password);
        users.setAdress(signUpDTO.getAdress());
        // Şifre doğrulaması
        if (!PasswordValidator.validatePassword(password)) {
            throw new RuntimeException("Password does not meet the required criteria!");
        }
        User usersControl= userRepository.findByEmailAndPassword(users.getEmail(), password);
        if(usersControl==null){
            userRepository.save(users);
        }else{
            throw new RuntimeException("User already exists!");
        }

        return users;
    }
}
