package com.example.teachertask.allusers;

import com.example.teachertask.favorites.Favorites;
import com.example.teachertask.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "all_users")
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String phoneNumber;
    private String adress;
    private String userName;
    private String role;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Task> tasks;


    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Favorites> favorites;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return email;
    }
    public String getEmail() {
        return email;
    }

}
