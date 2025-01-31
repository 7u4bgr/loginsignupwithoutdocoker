package com.example.teachertask.login;

import com.example.teachertask.allusers.User;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LoginMapping {

    LoginDTO loginDto(User user);

    User user(LoginDTO loginDto);


}
