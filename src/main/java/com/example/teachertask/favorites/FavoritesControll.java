package com.example.teachertask.favorites;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/add")
public class FavoritesControll {
    private final FavoritesService favoritesService;
    public FavoritesControll(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;

    }
    @PostMapping("/favorites")
    public Favorites addFavorites(@RequestBody Favorites favorites) {
        return favoritesService.addFavorites(favorites);
    }
    @GetMapping("/allFavorites")
    public List<Favorites> getAllFavorites() {
        return favoritesService.getAllFavorites();
    }
    @DeleteMapping("/delete/{Id}")
    public String deleteFavorites(@PathVariable int Id) {
        favoritesService.deleteFavorites(Id);
        return "Silindi";
    }
    @GetMapping("/favorite/{userId}")
    public List<Favorites> getFavorites(@PathVariable int userId) {
        return favoritesService.getFavorites(userId);
    }
    @PostMapping("/add/{userId}/{taskId}")
    public ResponseEntity<String> addTaskToFavorites(@PathVariable Long userId, @PathVariable Long taskId) {
        favoritesService.addTaskToFavorites(userId, taskId);
        return ResponseEntity.ok("Task added to favorites successfully!");
    }

}
