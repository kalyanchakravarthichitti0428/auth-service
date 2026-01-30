package com.portal.auth_service.config;

import com.portal.auth_service.entity.User;
import com.portal.auth_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByUsername("teacher1").isEmpty()) {
                userRepository.save(
                        User.builder()
                                .username("teacher1")
                                .password(passwordEncoder.encode("password123"))
                                .role("TEACHER")
                                .build()
                );
            }
        };
    }
}
