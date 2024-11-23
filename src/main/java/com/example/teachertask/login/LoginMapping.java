package com.example.teachertask.login;

import com.example.teachertask.allusers.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoginMapping {
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    LoginDTO loginDto(User user);
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User user(LoginDTO loginDto);
}
