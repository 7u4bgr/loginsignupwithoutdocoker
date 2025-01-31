package com.example.teachertask.allusers;

import com.example.teachertask.mailsender.TaskSender;
import com.example.teachertask.task.Task;
import com.example.teachertask.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final TaskRepository taskRepository;
    @Autowired
    private final TaskSender taskSender;
    public UserService(UserRepository userRepository, TaskRepository taskRepository, TaskSender taskSender) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.taskSender = taskSender;
    }

    public ResponseEntity<List<User>> showAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
    public ResponseEntity<String> deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
    public ResponseEntity<User> updateUser(Long userId, User updateUser) {
        Optional<User> oldUser = userRepository.findById(userId);
        if (oldUser.isPresent()) {
            User newUser = oldUser.get();

            newUser.setUserName(updateUser.getUsername());
            newUser.setPassword(updateUser.getPassword());
            newUser.setEmail(updateUser.getEmail());
            newUser.setRole(updateUser.getRole());
            newUser.setPhoneNumber(updateUser.getPhoneNumber());
            newUser.setAdress(updateUser.getAdress());
            newUser.setRole(updateUser.getRole());
            User savedUser = userRepository.save(newUser);
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.badRequest().body(null);
        }

    }
//    public ResponseEntity<String> assignTask(Long userId, Long taskId) {
//        Optional<User> user = userRepository.findById(userId);
//        Optional<Task> task = taskRepository.findById(taskId);
//
//        if (user.isPresent() && task.isPresent()) {
//            User user1 = user.get();
//            Task task1 = task.get();
//
//            user1.getTasks().add(task1); // Görev ekleniyor
//            userRepository.save(user1); // Güncellenmiş kullanıcıyı kaydet
//        String subject="You have assigned a task";
//         String body="Hello "+ user1.getUserName()+",\n\n"
//            + "You are now assigned a task: " + task1.getTitle() + "\n"
//            +"Description Task: "+ task1.getDescription()+"\n\n"
//
//            +"Good Luck!";
//    taskSender.sendEmail(user1.getEmail(), subject, body);
//            return ResponseEntity.ok("Task assigned successfully");
//        } else {
//            return ResponseEntity.badRequest().body("User or Task not found");
//        }
//    }
//
//    public ResponseEntity<List<Task>> showUserTask(String email) {
//        Optional<User> userOptional = userRepository.findByEmail(email);
//        if (userOptional.isPresent()) {
//            User user1 = userOptional.get();
//            return ResponseEntity.ok(user1.getTasks());
//        } else {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    public ResponseEntity<String> updateTaskById(Long taskId, String email) {
//        Optional<User> newUserOptional = userRepository.findByEmail(email);
//        Optional<Task> taskOptional = taskRepository.findById(taskId);
//
//        if (newUserOptional.isPresent() && taskOptional.isPresent()) {
//            User newUser = newUserOptional.get();
//            Task task1 = taskOptional.get();
//            //Last task User
//            Optional<User> oldUserOptional = userRepository.findUserByTaskId(taskId);
//            //When have old task and user and remove
//            oldUserOptional.ifPresent(oldUser -> {
//                oldUser.getTasks().remove(task1);
//                userRepository.save(oldUser);
//            });
//            //Add new user task
//
//            newUser.getTasks().add(task1);
//            userRepository.save(newUser);
//            return ResponseEntity.ok("Task updated and assigned successfully");
//        } else {
//            return ResponseEntity.badRequest().body("User or Task not found");
//        }
//    }
//

//

//
//    public ResponseEntity<String> deleteAllUsers() {
//       userRepository.deleteAll();
//       return ResponseEntity.ok("All users deleted successfully");
//    }
//





}
