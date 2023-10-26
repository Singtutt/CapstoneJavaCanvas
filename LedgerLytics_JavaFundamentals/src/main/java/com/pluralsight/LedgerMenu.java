package com.pluralsight;
import java.util.*;

public class LedgerMenu { // Ledger Menu Screen pushed to Main Menu when called upon.
    public static void menuLedger(List<Data> ledger, Scanner scanner) {
        try {
            while (true) {
                System.out.println("~Ledger Menu~\n" +
                        "A: Display All Entries\n" +
                        "B: Display Only Deposits\n" +
                        "C: Display Only Payments (Debits)\n" +
                        "D: Report Menu\n" +
                        "E: Go back to Main Menu\n" +
                        "Please select an option (A-E): ");
                String option = scanner.nextLine().toUpperCase();

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
                        ReportMenu.menuReport(ledger, scanner);
                        break;
                    case "E":
                        System.out.println("Closing Ledger Menu.\n" +
                                "Back to...");
                        return;
                    default:
                        System.out.println("Invalid Option Input. Please select a valid option (A-E)");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ledger Processing Error: " + e.getMessage());
        }
    }
}
