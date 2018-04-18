package com.placeholder.threelevels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ThreeLevelsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ThreeLevelsApplication.class, args);
  }
}
