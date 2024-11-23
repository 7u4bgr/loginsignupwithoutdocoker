package com.example.teachertask.login;

import com.example.teachertask.allusers.User;
import com.example.teachertask.allusers.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {
    private final UserRepository userRepository;


    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    public User loginUser(LoginDTO loginDTO) {
    //Teze bir metod yaradiramki repositorymda find eleyib tapsin
        User users = userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
            if(users != null) {
                return users;
            }else{
                return null;
            }

//        log.info("LOGUMUZ BUDU :"+girisMethodu.toString());


    }

}
