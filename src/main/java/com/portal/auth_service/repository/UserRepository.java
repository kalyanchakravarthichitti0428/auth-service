package com.portal.auth_service.repository;

import com.portal.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}


        /*
        Spring Security needs to load users by username
        Optional avoids null bugs

         */