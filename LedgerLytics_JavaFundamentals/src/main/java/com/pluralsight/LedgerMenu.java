package com.pluralsight;
import java.util.*;

public class LedgerMenu { // Ledger Menu Pushed to Main Menu
    public static void menuLedger(List<Data> ledger) {
        Scanner scanL = new Scanner(System.in);
        boolean process = false;

        while (!process) {
            System.out.println("~Ledger Menu~\nA: Display All Entries\nB: Display Only Deposits\nC: Display Only Payments\nD: Report Menu\nE: Go back to Main Menu\nPlease select an option (A-E): ");
            String option = scanL.nextLine().toUpperCase();

            switch (option) {
                case "A":
                    LOptions.allEntries(ledger);
                    break;
                case "B":
                    LOptions.depositEntries(ledger);
                    break;
                case "C":
                    LOptions.paymentEntries(ledger);
                    break;
                case "D":
                    ReportMenu.menuReport();
                    break;
                case "E":
                    System.out.println("Directing back to Main Menu...");
                    process = true;
                    break;
                default:
                    System.out.println("Invalid Option Input. Please select a valid option (A-E)");
            }
        }
        scanL.close();
    }
}

