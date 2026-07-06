package com.soniXchange.model;

import com.soniXchange.domain.VerificationType;

import jakarta.persistence.*;
import lombok.Data;

/**
 * TwoFactorAuth
 *
 * Represents two‑factor authentication (2FA) settings for a user.
 * Provides an option to enable or disable 2FA and specifies
 * the verification method (e.g., MOBILE or EMAIL).
 */
@Data
@Embeddable
public class TwoFactorAuth {
  /**
   * Indicates whether 2FA is enabled for the user.
   * Defaults to false.
   */
  private boolean isEnabled = false;

  /**
   * The medium through which 2FA verification codes are sent
   * (e.g., MOBILE or EMAIL).
   */
  // @Enumerated(EnumType.STRING)
  private VerificationType sendTo;
}
