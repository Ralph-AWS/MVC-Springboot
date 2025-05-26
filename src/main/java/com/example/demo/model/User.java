package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.validation.PhoneNumber;
import com.example.demo.validation.ValidPassword;
import com.example.demo.validation.ValidationGroups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "First name is required. ")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required. ")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull(message = "Date of birth is required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @NotBlank(message = "Gender is required. ")
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotBlank(message = "Username is required. ")
    @Size(min = 4, message = "Username must be at least 4 characters")
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotBlank(groups = ValidationGroups.Create.class, message = "Password is required.")
    @ValidPassword(groups = {ValidationGroups.Create.class, ValidationGroups.Update.class})
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "Email is required. ")
    @Email(message = "Invalid email")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Phone number is required. ")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10-digit")
    @PhoneNumber
    @Column(name = "phone", nullable = false)
    private String phoneNumber;

    @AssertTrue(message = "You must agree to the terms and conditions")
    @Column(name = "terms", nullable = false)
    private boolean termsAndConditions;

}
