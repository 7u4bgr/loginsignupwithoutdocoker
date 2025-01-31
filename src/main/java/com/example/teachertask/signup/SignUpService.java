package com.example.teachertask.signup;

import com.example.teachertask.allusers.User;
import com.example.teachertask.allusers.UserRepository;
import com.example.teachertask.role.Role;
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
        User users = new User();
        users.setUserName(signUpDTO.getUserName());
        users.setPhoneNumber(signUpDTO.getPhoneNumber());
        users.setEmail(signUpDTO.getEmail());
        users.setPassword(password);
        users.setAdress(signUpDTO.getAdress());


        if (!PasswordValidator.validatePassword(password)) {
            throw new RuntimeException("Parol Duzgun yazilmadi");
        }

        users.setRole("USER");
        User usersControl = userRepository.findByEmailAndPassword(users.getEmail(), password);
        if (usersControl == null) {
            userRepository.save(users);
        } else {
            throw new RuntimeException("Bu emaile aid hesab movcuddur!");
        }

        return users;
    }

    public User addAdmin(SignUpDTO admin) {
        String password = admin.getPassword();
        String role= String.valueOf(admin.getRole());
        User users = new User();

        users.setUserName(admin.getUserName());
        users.setPhoneNumber(admin.getPhoneNumber());
        users.setEmail(admin.getEmail());
        users.setPassword(password);
        users.setAdress(admin.getAdress());
        if("ADMIN".equalsIgnoreCase(role)) {
            users.setRole("ADMIN");
        }else{
            users.setRole("USER");
        }


        if (!PasswordValidator.validatePassword(password)) {
            throw new RuntimeException("Password does not meet the required criteria!");
        }

        // Kullanıcı kontrolü
        User usersControl = userRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
        if (usersControl == null) {
            userRepository.save(users);
        } else {
            throw new RuntimeException("User already exists!");
        }

        return users;
    }
}
