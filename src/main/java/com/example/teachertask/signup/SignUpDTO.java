package com.example.teachertask.signup;

import com.example.teachertask.role.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDTO {


    private String phoneNumber;
    private String adress;
    private String userName;
    private String email;
    private String password;
    private Role role;


}
