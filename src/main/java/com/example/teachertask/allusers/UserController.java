package com.example.teachertask.allusers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Admin Panel hissesi
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> showAllUsers() {
        return userService.showAllUsers();
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId) {
        return userService.deleteUserById(userId);
    }
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }
//    @PostMapping("/{userId}/assignTask/{taskId}")
//    public ResponseEntity<String> assignTask(@PathVariable Long userId, @PathVariable Long taskId) {
//        return userService.assignTask(userId,taskId);
//    }
//    @GetMapping("/{email}/tasks")
//    public ResponseEntity<List<Task>> showUserTask(@PathVariable String email) {
//        return userService.showUserTask(email);
//    }


//    @PutMapping("/{taskId}/updateTask/{email}")
//    public ResponseEntity<String> updateTaskById(@PathVariable Long taskId, @PathVariable String email) {
//        return userService.updateTaskById(taskId,email);
//    }
//    @DeleteMapping("/deleteAllUsers")
//    public ResponseEntity<String> deleteAllUsers() {
//        return userService.deleteAllUsers();
//    }





}