package com.epicode.InfoSalute.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.InfoSalute.security.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
