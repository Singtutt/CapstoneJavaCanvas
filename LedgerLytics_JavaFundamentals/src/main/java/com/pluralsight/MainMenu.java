package com.pluralsight;
import java.util.*;

public class MainMenu {
    private static final List<Data> ledger = new ArrayList<>();
    private static Scanner scanMM = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("~Main Menu~\n" +
                    "A: Add Deposit\n" +
                    "B: Make Payment (Debit)\n" +
                    "C: Ledger Menu\n" +
                    "D: Exit Program\n" +
                    "Please select an option (A-D)");
            String option = scanMM.nextLine().toUpperCase();

            switch (option) { // Options A/B pulled from MOptions Class; Option C pulled from LedgerMenu Class
                case "A":
                    do {
                        MOptions.addDeposit(ledger);
                        System.out.println("Another Deposit? (Y/N): ");
                        String choice = scanMM.nextLine().toUpperCase();
                        if (!choice.equals("Y"))
                            break;
                    } while (true);
                    break;
                case "B":
                    do {
                        MOptions.makePayment(ledger);
                        System.out.println("Another Payment? (Y/N): ");
                        String choice = scanMM.nextLine().toUpperCase();
                        if (!choice.equals("Y"))
                            break;
                    } while (true);
                    break;
                case "C":
                    LedgerMenu.menuLedger(ledger);
                    break;
                case "D":
                    System.out.println("Exiting Application.\n" +
                            "Goodbye...");
                    scanMM.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option Input. Please select a valid option (A-D)");
            }
        }
    }
}
