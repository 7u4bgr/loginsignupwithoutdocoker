package com.example.teachertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private final JwtUtil jwtUtil=new JwtUtil();


    @PostMapping("/login")
    public Map<String,String> login(@RequestBody Map<String,String> user){
        String username=user.get("username");
        String password=user.get("password");

        String role=null;
        if("admin".equals(username)&&"password".equals(password)){
            role="ADMIN";
        }else if("user".equals(username)&&"password".equals(password)){
            role="USER";
        }




        if(role!=null){
            String token=jwtUtil.generateToken(username,role);
            Map<String,String> response=new HashMap<>();
            response.put("token",token);
            response.put("role",role);
            return response;
        }
        else{
            throw new RuntimeException("Sehv user daxil oldu");
        }
    }
}
