package com.soniXchange.domain;

/**
 * USER_ROLE
 *
 * Defines the available roles for users in the SoniXchange platform.
 * These roles are used for access control within the application.
 *
 * Role names are prefixed with "ROLE_" to align
 * with Spring Security’s expectations for role-based authorization.
 */
public enum USER_ROLE {
  ROLE_ADMIN, // Grants administrative privileges
  ROLE_CUSTOMER // Grants standard customer privileges
}
