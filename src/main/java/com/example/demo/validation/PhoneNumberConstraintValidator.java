package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberConstraintValidator implements ConstraintValidator<PhoneNumber, String> {
    private String prefix;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        if (phone == null) return false;
        return phone.startsWith(prefix);
    }
}