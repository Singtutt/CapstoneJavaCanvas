package com.pluralsight;
import java.time.*;
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
//    Setters
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Entry cannot be negative");
        }
    }
    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatDate = date.format(dateFormat);
        String formatTime = time.format(timeFormat);
        return formatDate + " | " + formatTime + " | " + description + " | " + vendor + " | " + amount;
    }
}
