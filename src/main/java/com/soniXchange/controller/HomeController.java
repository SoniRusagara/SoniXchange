package com.soniXchange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 * This controller provides a simple landing endpoint for
 * the SoniXChange platform. Serves as the entry point
 * to verify that the application is running successfully.
 */
@RestController
public class HomeController {


  /**
   * Returns a welcome message for the SoniXChange platform.
   *
   * @return String - user‑friendly welcome message.
   */
  @GetMapping
  public String home(){
    return "Welcome to SoniXChange Platform";
  }
}
