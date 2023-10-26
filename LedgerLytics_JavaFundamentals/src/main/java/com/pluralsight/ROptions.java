package com.pluralsight;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ROptions {
    public static void optionA(List<Data> ledger) {
        LocalDate presentDate = LocalDate.now();
        int presentMonth = presentDate.getMonthValue();
        int presentYear = presentDate.getYear();
        System.out.println("Month to Date:");
        for (Data entry : ledger) {
            LocalDate entryDate = entry.getDate();
            if (entryDate.getMonthValue() == presentMonth && entryDate.getYear() == presentYear) {
                System.out.println(entry.dataFormat());
            }
        }
    }
    public static void optionB(List<Data> ledger) {
        LocalDate presentDate = LocalDate.now();
        LocalDate configMonth = presentDate.minusMonths(1);
        System.out.println("Previous Month:");
        for (Data entry : ledger) {
            LocalDate entryDate = entry.getDate();
            if (entryDate.getMonthValue() == configMonth.getMonthValue() && entryDate.getYear() == configMonth.getYear()) {
                System.out.println(entry.dataFormat());
            }
        }
    }
    public static void optionC(List<Data> ledger) {
        LocalDate presentDate = LocalDate.now();
        int presentYear = presentDate.getYear();
        System.out.println("Year to Date:");
        for (Data entry : ledger) {
            LocalDate entryDate = entry.getDate();
            if (entryDate.getYear() == presentYear) {
                System.out.println(entry.dataFormat());
            }
        }
    }
    public static void optionD(List<Data> ledger) {
        LocalDate presentDate = LocalDate.now();
        LocalDate configYear = presentDate.minusYears(1);
        System.out.println("Previous Year:");
        for (Data entry : ledger) {
            LocalDate entryDate = entry.getDate();
            if (entryDate.getYear() == configYear.getYear()) {
                System.out.println(entry.dataFormat());
            }
        }
    }
    public static void optionE(List<Data> ledger, Scanner scanner) {
            System.out.println("Vendor Name: ");
            String nameVendor = scanner.nextLine();
            System.out.println("Vendor Entries: " + nameVendor);
            for (Data entry : ledger) {
                if (entry.getVendor().equalsIgnoreCase(nameVendor)) {
                    System.out.println(entry.dataFormat());
                }
            }
    }
}
