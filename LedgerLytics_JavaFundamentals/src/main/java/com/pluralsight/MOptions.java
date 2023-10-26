package com.pluralsight;
import java.time.*;
import java.io.*;
import java.util.*;

public class MOptions {
    public static void addDeposit(List<Data> ledger, Scanner scanner) {
        try {
            LocalDate presentDate = LocalDate.now();
            LocalTime presentTime = LocalTime.now();
            System.out.println("Deposit Information:\n" +
                    "Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("Item Description: ");
            String description = scanner.nextLine();
            double amount = userInput(scanner);

            Data deposit = new Data(presentDate, presentTime, description, vendor, amount);
            ledger.add(deposit);
            System.out.println("Deposit Successfully Recorded.");
        } catch (Exception e) {
            exceptionControl("Deposit", e);
        }
    }
    public static void makePayment(List<Data> ledger, Scanner scanner) {
        try {
            LocalDate presentDate = LocalDate.now();
            LocalTime presentTime = LocalTime.now();

            System.out.println("Debit Information:\n" +
                    "Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("Item Description: ");
            String description = scanner.nextLine();
            double amount = -userInput(scanner);

            Data payment = new Data(presentDate, presentTime, description, vendor, amount);
            ledger.add(payment);
            System.out.println("Debit Successfully Recorded.");
        } catch (Exception e) {
            exceptionControl("Debit", e);
        }
    }
    private static void exceptionControl(String operation, Exception e) {
        e.printStackTrace();
        System.out.println(operation + " Unsuccessfully Recorded: " + e.getMessage());
    }
    private static double userInput(Scanner scanner) {
        double amount;
        while (true) {
            System.out.println("Amount: ");
            String amountEntry = scanner.nextLine();
            try {
                amount = Double.parseDouble(amountEntry);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Amount Entry. Please enter a valid number.");
            }
        }
        return amount;
    }
}
