package com.pluralsight;
import java.util.*;

public class LedgerMenu { // Ledger Menu Pushed to Main Menu
    public static void menuLedger(List<Data> ledger) {
        Scanner scanL = new Scanner(System.in);

        while (true) {
            System.out.println("~Ledger Menu~\n" +
                    "A: Display All Entries\n" +
                    "B: Display Only Deposits\n" +
                    "C: Display Only Payments\n" +
                    "D: Report Menu\n" +
                    "E: Go back to Main Menu\n" +
                    "Please select an option (A-E): ");
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
                    ReportMenu.menuReport(ledger);
                    break;
                case "E":
                    System.out.println("Closing Ledger Menu.\n" +
                            "Back to...");
                    scanL.close();
                    break;
                default:
                    System.out.println("Invalid Option Input. Please select a valid option (A-E)");
            }
        }
    }
}
