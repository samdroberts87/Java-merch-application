package com.merchandise.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {

    public static boolean isValidEmail(String email) {
        /**
         * This method is used to validate the email address using a pattern I searched for online
         */

        String emailRegexPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegexPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidLicense(String license) {

        /**
         * This method is used to validate the driving license number for UK driving licenses, using a pattern I searched for online
         */
        String licensePattern = "^[A-Z9]{5}\\d{6}[A-Z9]{2}\\d[A-Z]{2}$";
        Pattern pattern = Pattern.compile(licensePattern);
        Matcher matcher = pattern.matcher(license);
        return matcher.matches();
    }


}
