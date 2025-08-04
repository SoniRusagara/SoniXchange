package com.soniXchange.repository;

import com.soniXchange.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Managing the data in the data base using this repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
