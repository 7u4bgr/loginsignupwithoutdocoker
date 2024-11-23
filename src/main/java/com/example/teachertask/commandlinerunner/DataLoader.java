//package com.example.teachertask.commandlinerunner;
//
//import com.example.teachertask.allusers.User;
//import com.example.teachertask.allusers.UserService;
//import com.example.teachertask.role.Role;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    private final UserService userService;
//
//    public DataLoader(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Admin rolü
//        Role adminRole = new Role();
//        adminRole.setName("ROLE_ADMIN");
//
//        // Admin kullanıcı
//        User admin = new User();
//        admin.setFirstName("Admin");
//        admin.setLastName("User");
//        admin.setEmail("admin@example.com");
//        admin.setPassword("adminpassword");
//
//        // Rolleri ekle
//        admin.getRoles().add(adminRole);
//
//        userService.createUser(admin);
//    }
//}
//
