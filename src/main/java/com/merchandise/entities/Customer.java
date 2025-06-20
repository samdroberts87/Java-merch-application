package com.merchandise.entities;

import com.merchandise.regex.Regex;

import java.util.ArrayList;

public final class Customer extends Merchandise{
    //class params
    private String creditLimit; //Not Beyond 50,000
    private String phoneNumber; //10 digits
    private String email; //proper format (use regex expression)

    /**
     * constructor
     * all params available to this class are:
     * @param partnerId
     * @param partnerName
     * @param city
     * @param state
     * @param creditLimit
     * @param phoneNumber
     * @param email
     */
    public Customer(String partnerId, String partnerName, String city, String state, String creditLimit, String phoneNumber, String email) {
        super(partnerId, partnerName, city, state); // taken from parent
        setCreditLimit(creditLimit); // setting values with validated setter method
        setPhoneNumber(phoneNumber); // setting values with validated setter method
        setEmail(email); // setting values with validated setter method
    }

    // getters and setters
    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        int convertedCreditLimit;
        try {
            convertedCreditLimit = Integer.parseInt(creditLimit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("credit limit is mandatory must be a number");
        }
        if (convertedCreditLimit > 50000) {
            throw new IllegalArgumentException("credit limit cannot exceed 50,000"); // throw exception if value is over 50,000
        }
        this.creditLimit = creditLimit;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            throw new IllegalArgumentException("phone number must be 10 digits"); // throw exception if phone number is not exactly 10 digits
        }
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!Regex.isValidEmail(email)) {
            throw new IllegalArgumentException("This email is not valid");  // throw exception if email address doesn't meet patter set out in isValidEmail method of com.merchandise.regex
        }
        this.email = email;
    }

    //to string method
    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "creditLimit=" + creditLimit +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }

    // validation method (although input is validated upon entry)
    @Override
    public String[] validate(Merchandise merc) {
        ArrayList<String> result = new ArrayList<>();

        String[] baseValidation = super.validate(merc); // Call parent validation function
        result.addAll(java.util.Arrays.asList(baseValidation));

        Customer customer = (Customer) merc;
        int convertedCreditLimit = Integer.parseInt(customer.getCreditLimit());
        if (convertedCreditLimit > 50000) {
            result.add("credit limit cannot exceed 50,000");
        }
        if (customer.getPhoneNumber() == null || customer.getPhoneNumber().length() != 10) {
            result.add("phone number must be exactly 10 digits");
        }
        if (customer.getEmail() == null || !Regex.isValidEmail(customer.getEmail())) {
            result.add("email format is invalid");
        }
        return result.toArray(new String[0]);
    }
}
