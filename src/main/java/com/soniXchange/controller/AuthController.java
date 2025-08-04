package com.soniXchange.controller;

import com.soniXchange.model.User;
import com.soniXchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController
 *
 * Provides authentication-related endpoints
 * for the SoniXchange platform. This controller
 * currently handles user registration (sign-up).
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

  /**
   * Repository for interacting with the User entity in the database.
   * Automatically injected by Spring using dependency injection.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * Registers a new user in the system.
   *
   * @param user User object containing email and password details.
   * @return ResponseEntity with the created User and HTTP
   * status code 201 (Created).
   */
  @PostMapping("/signup")
  public ResponseEntity<User> register(@RequestBody User user){

    // debug the following:
    User newUser = new User();
    newUser.setEmail(user.getEmail());
    newUser.setPassword(user.getPassword());
    newUser.setEmail(user.getEmail());

    // Persist user in DB
    User savedUser = userRepository.save(newUser);

    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

  }
}
