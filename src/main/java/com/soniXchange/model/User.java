package com.soniXchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.soniXchange.domain.USER_ROLE;
import jakarta.persistence.*;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * User Entity
 *
 * Represents a user in the SoniXchange platform.
 * This class is mapped to a database table using JPA/Hibernate
 * and leverages Lombok to reduce boilerplate code for
 * getters, setters, equals, hashCode, and toString methods.
 */
@Entity
//@Data
@Table(name = "users")
public class User {
  /**
   * Unique identifier for each user.
   * Annotated with @Id to mark it as the primary key,
   * and @GeneratedValue to let the database auto-generate values.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // note: changed from .AUTO to .IDENTITY
  private long id;

  /**
   * Full name of the user.
   */
  @Column(nullable = false)
  private String fullName;
  /**
   * Email address of the user.
   * Serves as a primary contact and
   * can be used for authentication.
   */
  @Column(nullable = false, unique = true)
  private String email;

  //private String roles;
  private boolean isEnabled;
  private String sendTo;
  /**
   * Password for account authentication.
   * Marked with @JsonProperty(access = WRITE_ONLY) to ensure the password
   * can be written during input (e.g., registration) but is never exposed
   * in API responses for security reasons.
   */
  //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Column(nullable = false)
  private String password;

  // 2-Factor Authentication
  @Embedded
  private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();

  /**
   * Role assigned to the user.
   *
   * Defaults to ROLE_CUSTOMER to ensure that new users are granted
   * standard customer privileges unless explicitly set otherwise.
   */
  private USER_ROLE roles = USER_ROLE.ROLE_CUSTOMER;

//  // TODO: fix intellj not recognizing Lombok
//  public long getId() {
//    return id;
//  }
//
//  public void setId(long id) {
//    this.id = id;
//  }
//
//  public String getFullName() {
//    return fullName;
//  }
//
//  public void setFullName(String fullName) {
//    this.fullName = fullName;
//  }
//
//  public String getPassword() {
//    return password;
//  }
//
//  public void setPassword(String password) {
//    this.password = password;
//  }
//
//  public String getEmail() {
//    return email;
//  }
//
//  public void setEmail(String email) {
//    this.email = email;
//  }
//
//  public TwoFactorAuth getTwoFactorAuth() {
//    return twoFactorAuth;
//  }
//
//  public void setTwoFactorAuth(TwoFactorAuth twoFactorAuth) {
//    this.twoFactorAuth = twoFactorAuth;
//  }
//
//  public USER_ROLE getRoles() {
//    return roles;
//  }
//
//  public void setRoles(USER_ROLE roles) {
//    this.roles = roles;
//  }
}
