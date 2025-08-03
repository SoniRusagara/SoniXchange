package com.soniXchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Data
public class User {
  /**
   * Unique identifier for each user.
   * Annotated with @Id to mark it as the primary key,
   * and @GeneratedValue to let the database auto-generate values.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * Full name of the user.
   */
  private String fullName;
  /**
   * Email address of the user.
   * Serves as a primary contact and
   * can be used for authentication.
   */
  private String email;

  /**
   * Password for account authentication.
   * Marked with @JsonProperty(access = WRITE_ONLY) to ensure the password
   * can be written during input (e.g., registration) but is never exposed
   * in API responses for security reasons.
   */
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  // LEFT OFF HERE~~Future enhancement: Add role based access control
  //private USER_ROLE roles
}
