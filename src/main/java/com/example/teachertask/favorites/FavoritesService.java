package com.example.teachertask.favorites;

import com.example.teachertask.allusers.User;
import com.example.teachertask.allusers.UserRepository;
import com.example.teachertask.task.Task;
import com.example.teachertask.task.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FavoritesService {
    private final FavoritesRepository favoritesRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public FavoritesService(FavoritesRepository favoritesRepository, UserRepository userRepository, TaskRepository taskRepository) {
        this.favoritesRepository = favoritesRepository;

        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public Favorites addFavorites(@RequestBody Favorites favorites) {
        return favoritesRepository.save(favorites);
    }

    public List<Favorites> getAllFavorites() {
        return favoritesRepository.findAll();
    }


    public void deleteFavorites(int id) {
        favoritesRepository.deleteById(id);
    }

    public void addTaskToFavorites(Long userId, Long taskId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        Favorites favorites = favoritesRepository.findByUsers(user);
        if (favorites == null) {
            favorites = new Favorites();
            favorites.setUsers(user);
        }
        favorites.addTask(task);
        favoritesRepository.save(favorites);
    }

    public List<Favorites> getFavorites(int userId) {
        return favoritesRepository.findByUsersId(userId);
    }
}
