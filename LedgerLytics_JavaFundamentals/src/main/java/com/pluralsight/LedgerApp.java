package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class LedgerApp {
    private static final List<Data> ledger = new ArrayList<>();
    public static void mainMenu() {
        Scanner scan = new Scanner(System.in);
        boolean process = true;

        while (process) {
            System.out.println("~Main Menu~\nA: Add Deposit\nP: Make Payment (Debit)\nL: Ledger Menu\nX: Exit Program\nPlease select an option (A, P, L, X)");

            String option = scan.nextLine().toUpperCase();
            switch (option) {
                case "A":
                    depositOption();
                    break;
                case "P":
                    paymentOption();
                    break;
                case "L":
                    ledgerOption();
                    break;
                case "X":
                    process = false;
                    break;
                default:
                    System.out.println("Invalid Option Input. Please select a valid option (A, P, L, X)");
            }
        }
    }
    public static void depositOption() {
        Scanner scanDepo = new Scanner(System.in);
        System.out.println("Deposit Information:\nVendor Name: ");
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String vendor = scanDepo.nextLine();

        System.out.println("Description: ");
        String description = scanDepo.nextLine();

        System.out.println("Amount: ");
        double amount = scanDepo.nextDouble();

        String formatAmount = String.format("%.2f", amount);
        Data deposit = new Data(date, time, description, vendor, Double.parseDouble(formatAmount));
        ledger.add(deposit);
        System.out.println("Deposit recorded successfully.");
    }
    public static void paymentOption() {

    }
    public static void ledgerOption() {

    }
    public static void main(String[] args) {
        mainMenu();
    }
}
