package com.example.RecruitFlow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class AppUserRegistrationDto {
  @NotNull
  private String login;
  @NotNull
  @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*]).{8,}$", message = "The password must contain at least one uppercase letter, one special character and have at least 8 characters.")
  private String password;
  @NotNull
  @Email(message = "Incorrect email address format.")
  private String email;
}
