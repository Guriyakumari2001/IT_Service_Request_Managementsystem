package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.validators;

import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class RequestValidator {

    private static Pattern pattern;
    private static Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+$";

    public RequestValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    }

    public static boolean   validateEmail( String email) {
        System.out.println("Validating Email: " + email);
        if ( email == null || email.equals(""))
            {
            System.out.println("Email is null or empty");
            return false;
        }


        pattern = pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        if (matcher.matches()) {
            System.out.println("Email Pattern matched");
        } else {
            System.out.println("Email pattern didn't match");
        }
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(final String phoneNumber) {
        System.out.println("validating phone " + phoneNumber);
        if (isEmptyOrNull(phoneNumber)) {
            System.out.println("phone is empty or null");
            return false;
        } else {
            System.out.println("phone is not empty");
        }
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(phoneNumber);
        if (m.matches()) {
            System.out.println("phone Pattern matched");
        } else {
            System.out.println("phone didnt match");
        }
        return (m.matches());
    }

    public static boolean isEmptyOrNull(String s) {
        if (s == null || s.equals(""))
            return true;
        return false;
    }
}
