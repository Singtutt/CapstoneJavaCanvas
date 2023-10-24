package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class ReportMenu {
    public static void menuReport(List<Data> ledger) {
        Scanner scanR = new Scanner(System.in);
        boolean process = false;

        while (!process) {
            System.out.println("~Report Menu~\nA: Month to Date\nB: Previous Month\nC: Year to Date\nD: Previous Year\nE: Search by Vendor\nF: Go back to Ledger Menu\nPlease select an option (A-E): ");
            String option = scanR.nextLine().toUpperCase();

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
                    ROptions.optionE(ledger);
                    break;
                case "F":
                    System.out.println("Closing Report Menu...");
                    process = true;
                    break;
                default:
                    System.out.println("Invalid Option Input. Please select a valid option (A-E)");
            }
        }
    }
}
