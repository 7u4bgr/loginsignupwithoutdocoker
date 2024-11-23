package com.example.teachertask.signup;

import com.example.teachertask.allusers.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SignUpMapping {
    @Mapping(source = "organizationName", target = "organizationName")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "adress", target = "adress")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    SignUpDTO signUpDTO(User user);

    @Mapping(source = "organizationName", target = "organizationName")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "adress", target = "adress")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User user(SignUpDTO signUpDTO);

}
