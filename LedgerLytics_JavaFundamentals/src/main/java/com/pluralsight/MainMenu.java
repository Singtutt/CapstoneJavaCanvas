package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class MainMenu {
    private static final List<Data> ledger = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Initiate the "scanner"
            readCSV(); // Initiate current "Data"
            while (true) {
                System.out.println("~Main Menu~\n" +
                        "A: Add Deposit\n" +
                        "B: Make Payment (Debit)\n" +
                        "C: Ledger Menu\n" +
                        "D: Exit Program\n" +
                        "Please select an option (A-D)");
                String mainOption = scanner.nextLine().toUpperCase();
                switch (mainOption) { // Options A/B pulled from MOptions Class; Option C pulled from LedgerMenu Class
                    case "A": // Pulled from "MOptions"
                        do {
                            MOptions.addDeposit(ledger, scanner);
                            writeCSV();
                            System.out.println("Another Deposit? (Y/N): ");
                        } while (scanner.nextLine().equalsIgnoreCase("Y"));
                        break;
                    case "B": // Pulled from "MOptions"
                        do {
                            MOptions.makePayment(ledger, scanner);
                            writeCSV();
                            System.out.println("Another Payment? (Y/N): ");
                        } while (scanner.nextLine().equalsIgnoreCase("Y"));
                        break;
                    case "C": // Pulled from "LedgerMenu"
                        LedgerMenu.menuLedger(ledger, scanner);
                        break;
                    case "D":
                        System.out.println("Exiting Application.\n" +
                                "Goodbye...");
                        writeCSV();
                        return;
                    default:
                        System.out.println("Invalid Option Input. Please select a valid option (A-D)");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Main Processing Error: " + e.getMessage());
        }
    }
    private static void readCSV() {
        String filePath = "src/main/resources/transactions.csv";
        try (BufferedReader readFile = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = readFile.readLine()) != null) {
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
            e.printStackTrace();
            System.out.println("Error in Reading File: " + e.getMessage());
        }
    }
    private static void writeCSV() {
        String filePath = "src/main/resources/transactions.csv";
        try (FileWriter writeEntry = new FileWriter(filePath)) {
            for (Data entry : ledger) {
                String entryFormat = entry.dataFormat() + "\n";
                writeEntry.write(entryFormat);
            }
        } catch (IOException e) {
            System.out.println("Error Recording Entry: " + e.getMessage());
        }
    }
}
