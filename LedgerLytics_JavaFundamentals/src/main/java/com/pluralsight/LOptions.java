package com.pluralsight;
import java.util.*;
import java.io.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class LOptions {
    public static void allEntries(List<Data> ledger) {
        System.out.println("All Entries:");
        List<Data> orderEntries = new ArrayList<>(ledger);
        orderLedger(ledger);
        Collections.reverse(orderEntries);
        for (Data entry : ledger) {
            System.out.println(entry.dataFormat());
        }
    }
    public static void depositEntries(List<Data> ledger) {
        System.out.println("Deposit Entries:");
        List<Data> orderDeposit = new ArrayList<>(ledger);
        orderLedger(ledger);
        for (Data entry : ledger) {
            if (entry.getAmount() > 0) {
                orderDeposit.add(entry);
            }
        }
        Collections.reverse(orderDeposit);
        for (Data entry : orderDeposit) {
            System.out.println(entry.dataFormat());
        }
    }
    public static void paymentEntries(List<Data> ledger) {
        System.out.println("Payment Entries:");
        List<Data> orderPayment = new ArrayList<>(ledger);
        orderLedger(ledger);
        for (Data entry : ledger) {
            if (entry.getAmount() < 0) {
                orderPayment.add(entry);
            }
        }
        Collections.reverse(orderPayment);
        for (Data entry : orderPayment) {
            System.out.println(entry.dataFormat());
        }
    }
    public static void orderLedger(List<Data> ledger) {
        ledger.clear();
        String filePath = "src/main/resources/transactions.csv";
        try (BufferedReader readFile = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {
            String line;
            while   ((line = readFile.readLine()) != null) {
                String[] parts = line.split("\\|");
                LocalDate date = LocalDate.parse(parts[0].trim());
                LocalTime time = LocalTime.parse(parts[1].trim());
                String description = parts[2].trim();
                String vendor = parts[3].trim();
                double amount = Double.parseDouble(parts[4].trim());
                Data entry = new Data(date, time,description,vendor,amount);
                ledger.add(entry);
            }
        } catch (IOException e) {
            System.out.println("Error in Reading File.");
            e.printStackTrace();
        }
    }
}
