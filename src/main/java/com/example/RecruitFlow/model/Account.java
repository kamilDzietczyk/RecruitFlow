package com.example.RecruitFlow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Account")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String surname;
  private String street;
  private String city;
  @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$", message = "Incorrect postal code. The correct format is XX-XXX.")
  private String postal_code;
  @Pattern(regexp = "^(\\+48)?[ -]?[0-9]{9}$", message = "Incorrect phone number. The correct format is +48123456789 or 123456789.")
  private String phone_number;
  @Past(message = "The date of birth must be a date from the past.")
  private LocalDate birth_date;
  @OneToOne(mappedBy = "account")
  private AppUser appUser;
}
