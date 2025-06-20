package com.merchandise.consolepack;

import com.merchandise.entities.Customer;
import com.merchandise.services.Service;

import java.util.Scanner;
import java.util.Set;

public class Entry {

    public static void main(String[] args) {
        Service ser = new Service();

        while (true) {
            System.out.println("Select from below or type 'exit'\n1: Add Customer\n2: Add Supplier\n3: Display Customer report\n4: Display Supplier report\n5: Search for a customer\n");
            Scanner scanner = new Scanner(System.in);
            String firstInput = scanner.nextLine();

            if (firstInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting..");
                break;
            } else if (firstInput.equalsIgnoreCase("1")) {
                ser.option1();

            } else if (firstInput.equalsIgnoreCase("2")) {
                ser.option2();

            } else if (firstInput.equalsIgnoreCase("3")) {
                ser.option3();
            } else if (firstInput.equalsIgnoreCase("4")) {
                ser.option4();
            } else if (firstInput.equalsIgnoreCase("5")) {
                ser.option5();
            } else {
                System.out.println("invalid response. Try again");
                continue;
            }
        }
    }

}
