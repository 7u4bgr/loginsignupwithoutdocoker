package com.example.teachertask.allusers;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    User findByEmailAndPassword(String email, String password);

    @Query("SELECT u FROM User u JOIN u.tasks t WHERE t.id = :taskId")
    Optional<User> findUserByTaskId(@Param("taskId") Long taskId);

    Optional<User> findByEmail(String email);

    User findByUserName(String username);
}

