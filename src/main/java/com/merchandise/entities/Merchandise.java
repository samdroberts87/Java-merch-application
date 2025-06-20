package com.merchandise.entities;

import java.util.ArrayList;

public class Merchandise {
    private String partnerId; //Mandatory and Non-Negative
    private String partnerName; //Mandatory and Minimum 5 characters in length
    private String city; //Mandatory and Minimum 3 characters in length
    private String state; //Mandatory and Minimum 3 characters in length

    /**
     *
     * @param partnerId
     * @param partnerName
     * @param city
     * @param state
     */
    //param constructor
    public Merchandise(String partnerId, String partnerName, String city, String state) {
        setPartnerId(partnerId);
        setPartnerName(partnerName);
        setCity(city);
        setState(state);
    }

    //getters and setters
    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        int convertedPartnerId;
        try {
            convertedPartnerId = Integer.parseInt(partnerId);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("partnerId is mandatory and must be a non-negative number");

        }
        if (convertedPartnerId < 0) {
            throw new IllegalArgumentException("partnerId is mandatory and non-negative");
        }
        this.partnerId = partnerId; //Mandatory and Non-Negative
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        if (partnerName.length() < 5) {
            throw new IllegalArgumentException("partnerName must be at least 5 characters in length");
        }
        this.partnerName = partnerName; //Mandatory and Minimum 5 characters in length
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.length() < 3) {
            throw new IllegalArgumentException("city must be at least 3 characters in length");
        }
        this.city = city; //Mandatory and Minimum 3 characters in length
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state.length() < 3) {
            throw new IllegalArgumentException("state must be at least 3 characters in length");
        }
        this.state = state; //Mandatory and Minimum 3 characters in length
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "partnerId=" + partnerId +
                ", partnerName='" + partnerName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    // validation method (although input is validated upon entry)
    public String[] validate(Merchandise merc) {
        ArrayList<String> result = new ArrayList<>();
        int convertedPartnerId = Integer.parseInt(merc.getPartnerId());
        if (convertedPartnerId < 0) {
            result.add("partnerId is mandatory and non-negative");
        }
        if (merc.getPartnerName().length() < 5) {
            result.add("partnerName must be at least 5 characters in length");
        }
        if (merc.getCity().length() < 3) {
            result.add("city must be at least 3 characters in length");
        }
        if (merc.getState().length() < 3) {
            result.add("state must be at least 3 characters in length");
        }
        return result.toArray(new String[0]);
    }
}
