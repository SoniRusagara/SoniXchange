package com.soniXchange.controller;

import com.soniXchange.config.JwtProvider;
import com.soniXchange.model.User;
import com.soniXchange.repository.UserRepository;
import com.soniXchange.response.AuthResponse;
import com.soniXchange.service.CustomeUserDetailsService;

import java.net.PasswordAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

  @Autowired
  private CustomeUserDetailsService customeUserDetailsService;

  /**
   * Registers a new user in the system.
   *
   * @param user User object containing email and password details.
   * @return ResponseEntity with the created User and HTTP
   * status code 201 (Created).
      * @throws Exception 
      */
   @PostMapping("/signup")
   public ResponseEntity<AuthResponse> register(@RequestBody User user) throws Exception{
    User isEmailExist = userRepository.findByEmail(user.getEmail());

    if(isEmailExist != null){
      throw new Exception("Email is already used with another account");
    }

    User newUser = new User();
    newUser.setFullName(user.getFullName());
    newUser.setPassword(user.getPassword());
    newUser.setEmail(user.getEmail());

    

    // Persist user in DB
    User savedUser = userRepository.save(newUser);

    Authentication auth = new UsernamePasswordAuthenticationToken(
      user.getEmail(), 
      user.getPassword()
    );

    SecurityContextHolder.getContext().setAuthentication(auth);

    String jwt = JwtProvider.generateToken(auth);

    AuthResponse res = new AuthResponse();
    res.setJwt(jwt);
    res.setStatus(true);
    res.setMessage("register success");

    return new ResponseEntity<>(res, HttpStatus.CREATED);

  }


    /**
   * Enables a user to sign-in. 
   *
   * @param user User object containing email and password details.
   * @return ResponseEntity with the created User and HTTP
   * status code 201 (Created).
      * @throws Exception 
      */
    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> login(@RequestBody User user) throws Exception{
 
     String userName = user.getEmail();
     String password = user.getPassword();
     Authentication auth = authenticate(userName, password);
 
     SecurityContextHolder.getContext().setAuthentication(auth);
     String jwt = JwtProvider.generateToken(auth);
 
     AuthResponse res = new AuthResponse();
     res.setJwt(jwt);
     res.setStatus(true);
     res.setMessage("register success");
 
     return new ResponseEntity<>(res, HttpStatus.CREATED);
 
   }

   private Authentication authenticate(String userName, String password) {
    UserDetails userDetails = customeUserDetailsService.loadUserByUsername(userName);

    if(userDetails == null){
      throw new BadCredentialsException("invalid username");
    }

    if(password.equals(userDetails.getPassword())){
      throw new BadCredentialsException("invalid password");
    }

    return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

 
  }
}
