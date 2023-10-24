package com.pluralsight;
import java.util.List;

public class LOptions {
    public static void allEntries(List<Data> ledger) {
        System.out.println("All Entries:");
        for (Data entry : ledger) {
            System.out.println(entry.dataFormat());
        }
    }
    public static void depositEntries(List<Data> ledger) {
        System.out.println("Deposit Entries:");
        for (Data entry : ledger) {
            if (entry.getAmount() > 0) {
                System.out.println(entry.dataFormat());
            }
        }
    }
    public static void paymentEntries(List<Data> ledger) {
        System.out.println("Payment Entries:");
        for (Data entry : ledger) {
            if (entry.getAmount() < 0) {
                System.out.println(entry.dataFormat());
            }
        }
    }
}
