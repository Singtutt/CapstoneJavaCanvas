package com.pluralsight;
import java.util.*;

public class MainMenu {
    private static final List<Data> ledger = new ArrayList<>();
    public static void mainMenu() {
        Scanner scanMM = new Scanner(System.in);
        boolean process = false;

        while (!process) {
            System.out.println("~Main Menu~\nA: Add Deposit\nB: Make Payment (Debit)\nC: Ledger Menu\nD: Exit Program\nPlease select an option (A-D)");
            String option = scanMM.nextLine().toUpperCase();

            switch (option) { // Options A/B pulled from MOptions Class; Option C pulled from LedgerMenu Class
                case "A":
                    MOptions.addDeposit(ledger);
                    break;
                case "B":
                    MOptions.makePayment(ledger);
                    break;
                case "C":
                    LedgerMenu.menuLedger(ledger);
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
