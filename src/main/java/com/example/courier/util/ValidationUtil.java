package com.example.courier.util;

import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    public boolean isValidEmail(String email) {
        // Simple regex for email validation
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        // Simple regex for phone number validation
        return phoneNumber != null && phoneNumber.matches("^\\d{10}$");
    }
}
