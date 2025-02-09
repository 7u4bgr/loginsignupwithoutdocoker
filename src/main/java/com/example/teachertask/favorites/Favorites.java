package com.example.teachertask.favorites;

import com.example.teachertask.allusers.User;
import com.example.teachertask.task.Task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "all_favorites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(
            name = "favorites_task",
            joinColumns = @JoinColumn(name="favorites_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User users;

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}
