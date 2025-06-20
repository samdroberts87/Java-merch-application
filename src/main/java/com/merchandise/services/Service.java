package com.merchandise.services;

import com.merchandise.entities.Customer;
import com.merchandise.entities.Supplier;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {

    private ArrayList<Customer> custArray = new ArrayList<>();
    private ArrayList<Supplier> suppArray = new ArrayList<>();

    private void SaveCustomerDetails(Customer cust) {
        // save the customer details to an array.
        if (custArray.size() == 5) {
            throw new IllegalArgumentException("cannot add customer. Only 5 allowed.");
        }
        if (cust.validate(cust).length == 0) {
            custArray.add(cust);
        } else {
            System.out.println("Invalid data");
        }

    }

    private ArrayList<Customer> GetAllCustomers() {
        return custArray;
        // Gets and returns all the Customer details from the array.
    }

    private Customer GetCustomerById(String customerid) {
        for (int i = 0; i < custArray.size(); i++) {
            if (custArray.get(i).getPartnerId().equals(customerid)) {
                return custArray.get(i);
            }
        }
        return null;
//        Gets and returns the Customer details from the array based on id.
    }

    private void SaveSupplierDetails(Supplier supp) {
        if (suppArray.size() == 5) {
            throw new IllegalArgumentException("cannot add supplier. Only 5 allowed.");
        }
        if (supp.validate(supp).length == 0) {
            suppArray.add(supp);
        } else {
            System.out.println("Invalid data");
        }
        suppArray.add(supp);
        // which saves the Supplier details to the array.
    }
    private ArrayList<Supplier> GetAllSuppliers() {
        return suppArray;
        // Gets and returns all the Supplier details from the array.
    }

    public void option1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a partnerId: ");
        String partnerId = scanner.nextLine();
        System.out.print("enter a partnerName: ");
        String partnerName = scanner.nextLine();
        System.out.print("Enter a city: ");
        String city = scanner.nextLine();
        System.out.print("Enter a state: ");
        String state = scanner.nextLine();
        System.out.print("Enter a credit limit: ");
        String creditLimit = scanner.nextLine();
        System.out.print("Enter a phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter an email: ");
        String email = scanner.nextLine();

        try {
            Customer cust = new Customer(partnerId, partnerName, city, state, creditLimit, phoneNumber, email);
            SaveCustomerDetails(cust);
            System.out.println("Customer added\n");
        } catch (IllegalArgumentException e) {
            System.out.println("invalid entry. Please try again");
        }
    }

    public void option2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a partnerId: ");
        String partnerId = scanner.nextLine();
        System.out.print("enter a partnerName: ");
        String partnerName = scanner.nextLine();
        System.out.print("Enter a city: ");
        String city = scanner.nextLine();
        System.out.print("Enter a state: ");
        String state = scanner.nextLine();
        System.out.print("Enter a credit balance: ");
        String creditBalance = scanner.nextLine();
        System.out.print("Enter a driving license number: ");
        String drivingLicenseNumber = scanner.nextLine();

        try {
            Supplier supp = new Supplier(partnerId, partnerName, city, state, creditBalance, drivingLicenseNumber);
            SaveSupplierDetails(supp);
            System.out.println("Supplier added\n");
        } catch (IllegalArgumentException e) {
            System.out.println("invalid entry or Array full. Please try again");
        }

    }

    public void option3() {
        ArrayList<Customer> result = GetAllCustomers();
        if (result.isEmpty()) {
            System.out.println("array is empty");
        } else {
            System.out.println(result);
        }
    }

    public void option4() {
        ArrayList<Supplier> result = GetAllSuppliers();
        if (result.isEmpty()) {
            System.out.println("array is empty");
        } else {
            System.out.println(result);
        }
    }

    public void option5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a partnerId: ");
        String Id = scanner.nextLine();
        System.out.println(GetCustomerById(Id));
    }
}
