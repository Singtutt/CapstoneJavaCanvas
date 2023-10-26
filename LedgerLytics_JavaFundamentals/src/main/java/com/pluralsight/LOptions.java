package com.pluralsight;
import java.util.*;

public class LOptions {
    public static void allEntries(List<Data> ledger) {
        Collections.reverse(ledger);
        System.out.println("All Entries:");
        for (Data entry : ledger) {
            System.out.println(entry.dataFormat());
        }
    }
    public static void depositEntries(List<Data> ledger) {
        List<Data> depositEntries = new ArrayList<>();
        for (Data entry : ledger) {
            if (entry.getAmount() > 0) {
                depositEntries.add(entry);
            }
        }
        depositEntries.sort(Comparator.comparing(Data::getDate)
                .thenComparing(Data::getTime).reversed());
        System.out.println("Deposit Entries:");
        for (Data entry : depositEntries) {
            System.out.println(entry.dataFormat());
        }
    }
    public static void paymentEntries(List<Data> ledger) {
        List<Data> paymentEntries = new ArrayList<>();
        for (Data entry : ledger) {
            if (entry.getAmount() < 0) {
                paymentEntries.add(entry);
            }
        }
        paymentEntries.sort(Comparator.comparing(Data::getDate)
                .thenComparing(Data::getTime).reversed());
        System.out.println("Payment Entries:");
        for (Data entry : paymentEntries) {
            System.out.println(entry.dataFormat());
        }
    }
}