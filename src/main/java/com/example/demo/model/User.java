package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.validation.PhoneNumber;

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
public class User {

    @NotBlank(message = "First name is required. ")
    private String firstName;

    @NotBlank(message = "Last name is required. ")
    private String lastName;

    @NotNull(message = "Date of birth is required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @NotBlank(message = "Gender is required. ")
    private String gender;

    @NotBlank(message = "Username is required. ")
    @Size(min = 4, message = "Username must be at least 4 characters")
    private String username;

    @NotBlank(message = "Password is required. ")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Email is required. ")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Phone number is required. ")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10-digit")
    @PhoneNumber
    private String phoneNumber;

    @AssertTrue(message = "You must agree to the terms and conditions")
    private boolean termsAndConditions;

}
