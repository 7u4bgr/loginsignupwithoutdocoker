package com.example.teachertask.signup;
import com.example.teachertask.allusers.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SignUpMapping {
    SignUpDTO signUpDTO(User user);
    User user(SignUpDTO signUpDTO);
}
