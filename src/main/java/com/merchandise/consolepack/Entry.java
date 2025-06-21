package com.merchandise.consolepack;

import com.merchandise.services.Service;

import java.util.Scanner;

public class Entry {

    public static void main(String[] args) {
        Service ser = new Service();
        Scanner scanner = new Scanner(System.in);

        mainLoop:
        while (true) {
            System.out.println("Select from below or type 'exit'\n" +
                               "1: Add Customer\n" +
                               "2: Add Supplier\n" +
                               "3: Display Customer report\n" +
                               "4: Display Supplier report\n" +
                               "5: Search for a customer");

            String firstInput = scanner.nextLine().trim().toLowerCase();

            switch (firstInput) {
                case "1" -> ser.option1();
                case "2" -> ser.option2();
                case "3" -> ser.option3();
                case "4" -> ser.option4();
                case "5" -> ser.option5();
                case "exit" -> {
                    System.out.println("Exiting...");
                    break mainLoop;
                }
                default -> System.out.println("Invalid response. Try again.");
            }
        }

        scanner.close();
    }
}