package com.soniXchange.controller;

import com.soniXchange.config.JwtProvider;
import com.soniXchange.model.TwoFactorOTP;
import com.soniXchange.model.User;
import com.soniXchange.repository.UserRepository;
import com.soniXchange.response.AuthResponse;
import com.soniXchange.service.CustomeUserDetailsService;
import com.soniXchange.service.EmailService;
import com.soniXchange.service.TwoFactorOTPService;
import com.soniXchange.utils.OTPUtils;

import java.net.PasswordAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @Autowired
  private TwoFactorOTPService twoFactorOTPService;

  @Autowired
  private EmailService emailService;

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
    res.setMessage("Register success");

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

     User authUser = userRepository.findByEmail(userName);

     if(user.getTwoFactorAuth().isEnabled()){
      AuthResponse res = new AuthResponse();
      res.setMessage("Two factor auth is enabled");
      res.setTwoFactorAuthEnabled(true);
      String otp = OTPUtils.generateOTP();

      TwoFactorOTP oldTwoFactorOTP = twoFactorOTPService.findByUser(authUser.getId());
      if(oldTwoFactorOTP != null){
        twoFactorOTPService.deleteTwoFactorOtp(oldTwoFactorOTP);
      }

      TwoFactorOTP neTwoFactorOTP = twoFactorOTPService.createTwoFactorOTP(authUser, otp, jwt);

      // Send OTP email to users that have TwoFactorAuthentication enabled 
      emailService.sendVerificationOtpEmail(userName, otp);
      
      res.setSession(neTwoFactorOTP.getId());
      return new ResponseEntity<>(res, HttpStatus.ACCEPTED);

     }
 
     AuthResponse res = new AuthResponse();
     res.setJwt(jwt);
     res.setStatus(true);
     res.setMessage("Login success");
 
     return new ResponseEntity<>(res, HttpStatus.CREATED);
 
   }

   private Authentication authenticate(String userName, String password) {
    UserDetails userDetails = customeUserDetailsService.loadUserByUsername(userName);

    if(userDetails == null){
      throw new BadCredentialsException("invalid username");
    }

    if(!password.equals(userDetails.getPassword())){
      throw new BadCredentialsException("invalid password");
    }

    return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
  }

  public ResponseEntity<AuthResponse> verifySigninOTP(
    @PathVariable String otp, 
    @RequestParam String id) throws Exception {
   
      TwoFactorOTP twoFactorOTP = twoFactorOTPService.findById(id);

      if(twoFactorOTPService.verifyTwoFactorOtp(twoFactorOTP, otp)){
        AuthResponse res = new AuthResponse();
        res.setMessage("Two factor authentication verified");
        res.setTwoFactorAuthEnabled(true);
        res.setJwt(twoFactorOTP.getJwt());
        return new ResponseEntity<>(res, HttpStatus.OK);
      }
      throw new Exception("Invalid OTP");
  }


}
