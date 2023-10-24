package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Data {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;
    public Data(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
//    Getters
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
    public String getDescription() {
        return description;
    }
    public String getVendor() {
        return vendor;
    }
    public double getAmount() {
        return amount;
    }
    public String dataFormat() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatDate = date.format(dateFormat);
        String formatTime = time.format(timeFormat);
        return String.format("%s | %s | %s | %s | %.2f", formatDate, formatTime, description, vendor, amount);
    }
}
