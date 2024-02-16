package com.example.RecruitFlow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AppUser")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /*@NotNull*/
  @Column(nullable = false)
  private String login;

  /*@NotNull
  @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*]).{8,}$", message = "The password must contain at least one uppercase letter, one special character and have at least 8 characters.")*/
  @Column(nullable = false)
  private String password;

  /*@NotNull
  @Email(message = "Incorrect email address format.")*/
  @Column(nullable = false)
  private String email;

  @OneToOne
  @JoinColumn(name = "account_id", referencedColumnName = "id")
  private Account account;
}
