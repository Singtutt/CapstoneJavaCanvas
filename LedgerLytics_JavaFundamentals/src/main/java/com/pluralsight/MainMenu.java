package com.pluralsight;
import java.util.*;

public class MainMenu {
//    private static final List<Data> ledger = new ArrayList<>(); //Trial 1
    public static void mainMenu() {
        Scanner scanMM = new Scanner(System.in);
        boolean process = false;

        while (!process) {
            System.out.println("~Main Menu~\nA: Add Deposit\nP: Make Payment (Debit)\nL: Ledger Menu\nX: Exit Program\nPlease select an option (A, P, L, X)");
            String option = scanMM.nextLine().toUpperCase();

            switch (option) { // Options pull from other Java Classes
                case "A":
                    MOptions.addDeposit();
                    break;
                case "B":
                    MOptions.makePayment();
                    break;
                case "C":
                    LedgerMenu.menuLedger();
                    break;
                case "D":
                    System.out.println("Exiting Application... Goodbye!");
                    process = true;
                    break;
                default:
                    System.out.println("Invalid Option Input. Please select a valid option (A-D)");
            }
        }
        scanMM.close();
    }
}
//    public static void depositOption() { //Trial 1
//        Scanner scanDepo = new Scanner(System.in);
//        System.out.println("Deposit Information:\nVendor Name: ");
//        LocalDate date = LocalDate.now();
//        LocalTime time = LocalTime.now();
//        String vendor = scanDepo.nextLine();
//
//        System.out.println("Description: ");
//        String description = scanDepo.nextLine();
//
//        System.out.println("Amount: ");
//        double amount = scanDepo.nextDouble();
//
//        String formatAmount = String.format("%.2f", amount);
//        Data deposit = new Data(date, time, description, vendor, Double.parseDouble(formatAmount));
//        ledger.add(deposit);
//        System.out.println("Deposit recorded successfully.");
//    }
//    public static void paymentOption() {
//        Scanner scanPay = new Scanner(System.in);
//        System.out.println("Payment Information:\nDebit Card Number: ");
//        LocalDate date = LocalDate.now();
//        LocalTime time = LocalTime.now();
//        String cardNumber = scanPay.nextLine();
//
//        System.out.println("Expiration Date: ");
//        String dateExpire = scanPay.nextLine();
//        String[] dateSplit = dateExpire.split("/");
//        int monthExpire = Integer.parseInt(dateSplit[0]);
//        int yearExpire = Integer.parseInt(dateSplit[1]);
//
//        System.out.println("CVV: ");
//        int cardCVV = scanPay.nextInt();
//        scanPay.nextLine();
//
//        double amount;
//        while (true) {
//            System.out.println("Payment");
//            amount = scanPay.nextDouble();
//            scanPay.nextLine();
//
//            if (amount <= 0) {
//                System.out.println("Invalid Amount Input.\nMust be a positive integer.\nTry again.");
//            } else {
//                break;
//            }
//        }
//        amount = -amount;
//        String amountFormat = String.format("%.2f", amount);
//        Data payment = new Data(date, time, description, vendor, Double.parseDouble(amountFormat));
//        ledger.add(payment);
//        System.out.println("Payment recorded successfully");
//    }
//    public static void ledgerOption() {
//
//    }
//    public static void main(String[] args) {
//        mainMenu();
//    }