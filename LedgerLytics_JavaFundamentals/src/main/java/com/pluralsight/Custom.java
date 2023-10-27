package com.pluralsight;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;


public class Custom {
    public static void searchReport(List<Data> ledger, Scanner scanner) {
        System.out.println("Search Entries By... ");
        try {
//  Prompt User for Input (Utilizing Inter-(Aide)Method Parameters)
            LocalDate sDate = dateInput(scanner, "Start Date (example: 2023-10-27): ");
            LocalDate eDate = dateInput(scanner, "End Date (example: 2023-10-31): ");
            String description = localInput(scanner, "Item Description: ");
            String vendor = localInput(scanner, "Vendor: ");
            double amount = amountInput(scanner);
//  After Process is finalized, entries (Based off Search Criteria('s)) are Displayed
            System.out.println("Search Results:");
            ledger.sort((order1, order2) -> order2.getDate().compareTo(order1.getDate()));
            for (Data entry : ledger) {
                if (filterFields(entry, sDate, eDate, description, vendor, amount)) {
                    System.out.println(entry.dataFormat());
                }
            }
        }catch (Exception e) {
            System.out.println("Search Report Error: " + e.getMessage());
        }
    }
//  Process User Input and Compare to relative "Data" (Filter Field Input(s))
    private static boolean filterFields(Data entry, LocalDate sDate, LocalDate eDate, String description, String vendor, double amount) {
        boolean field = true; // If true; input(s) is used as a "Search Criteria('s)"
        LocalDate dataEntry = entry.getDate();
        if (sDate != null && !dataEntry.isAfter(sDate)) {
            field = false; // If false; lack of "valid" input(s) is ignored in "Search Criteria('s)"
        }
        if (eDate != null && !dataEntry.isBefore(eDate)) {
            field = false;
        }
        if (description != null && !entry.getDescription().equalsIgnoreCase(description)) {
            field = false;
        }
        if (vendor != null && !entry.getVendor().equalsIgnoreCase(vendor)) {
            field = false;
        }
        if (Math.abs(entry.getAmount()) != Math.abs(amount)) { // Required to Display both Positive and Negative entries
            field = false;
        }
        return field;
    }
//  Aide Methods
    private static LocalDate dateInput(Scanner scanner, String queryDate) {
        System.out.println(queryDate);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        return LocalDate.parse(input);
    }
    private static String localInput(Scanner scanner, String queryLocal) {
        System.out.println(queryLocal);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        return input;
    }
    private static double amountInput(Scanner scanner) {
        System.out.println("Amount: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(input);
    }
}
