package com.example.teachertask.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // CSRF korumasını devre dışı bırakır
                .cors().disable() // CORS ayarlarını devre dışı bırakır
                .authorizeRequests()
//                .requestMatchers("/api/tasks/allTask").hasRole("ADMIN") // Yalnızca admin erişimine izin verir
                .anyRequest().permitAll(); // Diğer tüm isteklere izin verir

        return http.build(); // SecurityFilterChain nesnesini döner
    }
}
