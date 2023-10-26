package com.pluralsight;
import java.util.List;
import java.util.Scanner;

public class ReportMenu {
    public static void menuReport(List<Data> ledger, Scanner scanner) {
        while (true) {
            System.out.println("~Report Menu~\n" +
                        "A: Month to Date\n" +
                        "B: Previous Month\n" +
                        "C: Year to Date\n" +
                        "D: Previous Year\n" +
                        "E: Search by Vendor\n" +
                        "F: Go back to Ledger Menu\n" +
                        "Please select an option (A-E): ");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "A":
                    ROptions.optionA(ledger);
                        break;
                case "B":
                    ROptions.optionB(ledger);
                    break;
                case "C":
                    ROptions.optionC(ledger);
                    break;
                case "D":
                    ROptions.optionD(ledger);
                    break;
                case "E":
                    ROptions.optionE(ledger, scanner);
                    break;
                case "F":
                    System.out.println("Closing Report Menu.\n" +
                            "Back to...");
                    return;
                default:
                    System.out.println("Invalid Option Input. Please select a valid option (A-F)");
            }
        }
    }
}
