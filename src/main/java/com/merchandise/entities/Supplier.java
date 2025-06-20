package com.merchandise.entities;

import com.merchandise.regex.Regex;

import java.util.ArrayList;

public class Supplier extends Merchandise{
    // class params
    private String creditBalance;
    private String drivingLicenseNumber;

    /**
     * constructor
     * all params available to this class are:
     * @param partnerId
     * @param partnerName
     * @param city
     * @param state
     * @param creditBalance
     * @param drivingLicenseNumber
     */
    public Supplier(String partnerId, String partnerName, String city, String state, String creditBalance, String drivingLicenseNumber) {
        super(partnerId, partnerName, city, state); // taken from parent
        setCreditBalance(creditBalance); // setting values with validated setter method
        setDrivingLicenseNumber(drivingLicenseNumber); // setting values with validated setter method
    }

    //getters and setters
    public String getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(String creditBalance) {
        int convertedCreditBalance;
        try {
            convertedCreditBalance = Integer.parseInt(creditBalance);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("credit limit is mandatory must be a number");
        }
        if (convertedCreditBalance > 175000) {
            throw new IllegalArgumentException("limit cannot exceed 175000"); // throw exception if limit is over 175000
        }
        this.creditBalance = creditBalance; //Not Beyond 1,75,000
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        if (!Regex.isValidLicense(drivingLicenseNumber)) {
            throw new IllegalArgumentException("that is not a valid UK driving license number"); // throw exception if drivingLicense doesn't meet patter set out in isValidLicense method of com.merchandise.regex
        }
        this.drivingLicenseNumber = drivingLicenseNumber; //Proper Format
    }

    //toString method
    @Override
    public String toString() {
        return "Supplier{" +
                super.toString() +
                "CreditBalance=" + creditBalance +
                ", DrivingLicenseNumber=" + drivingLicenseNumber +
                '}';
    }

    // validation method (although input is validated upon entry)
    @Override
    public String[] validate(Merchandise merc) {
        ArrayList<String> result = new ArrayList<>();

        String[] baseValidation = super.validate(merc); // Call parent validation function
        result.addAll(java.util.Arrays.asList(baseValidation));

        Supplier supplier = (Supplier) merc;
        int convertedCreditBalance = Integer.parseInt(supplier.getCreditBalance());
        if (convertedCreditBalance > 175000.00) {
            result.add("limit cannot exceed 175000");
        }
        if (!Regex.isValidLicense(supplier.getDrivingLicenseNumber())) {
            result.add("that is not a valid UK driving license number");
        }
        return result.toArray(new String[0]);
    }
}
