package com.example.teachertask.favorites;

import com.example.teachertask.allusers.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {
    Favorites findByUsers(User user);

    List<Favorites> findByUsersId(int userId);
}
