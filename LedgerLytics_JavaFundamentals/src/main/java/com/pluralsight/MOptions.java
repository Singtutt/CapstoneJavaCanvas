package com.pluralsight;
import java.time.*;
import java.io.*;
import java.util.*;

public class MOptions {
    public static void addDeposit(List<Data> ledger) {
        try (Scanner scanD = new Scanner(System.in)) {
            LocalDate presentDate = LocalDate.now();
            LocalTime presentTime = LocalTime.now();


            System.out.println("Deposit Information:\nVendor: ");
            String vendor = scanD.nextLine();
            System.out.println("Item Description: ");
            String description = scanD.nextLine();
            System.out.println("Amount: ");
            double amount = scanD.nextDouble();

            Data deposit = new Data(presentDate, presentTime, description, vendor, amount);
            ledger.add(deposit);
            saveEntry(deposit);
            System.out.println("Deposit Successfully Recorded.");
        }
    }
    public static void makePayment(List<Data> ledger) {
        try (Scanner scanP = new Scanner(System.in)) {
            LocalDate presentDate = LocalDate.now();
            LocalTime presentTime = LocalTime.now();


            System.out.println("Debit Information:\nVendor: ");
            String vendor = scanP.nextLine();
            System.out.println("Item Description: ");
            String description = scanP.nextLine();
            System.out.println("Amount: ");
            double amount = scanP.nextDouble();

            Data payment = new Data(presentDate, presentTime, description, vendor, -(amount));
            ledger.add(payment);
            saveEntry(payment);
            System.out.println("Debit Successfully Recorded.");
        }
    }
    private static void saveEntry(Data entry) {
        String filePath = "src/main/resources/transactions.csv";
        try (FileWriter writeEntry = new FileWriter(filePath, true)) {
            String entryFormat = entry.dataFormat() + "\n";
            writeEntry.write(entryFormat);
        } catch (IOException e) {
            System.out.println("Error in Recording Entry." + e.getMessage());
        }
    }
}
