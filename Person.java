package com.makegui.moon;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {

    private String name;
    private String email;
    private String phoneNumber;

    private LocalDate date0fBirth;

    public Person(String name, String email, String phoneNumber, LocalDate date0fBirth) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.date0fBirth = date0fBirth;
    }

    public Person(String name, String email, String phoneNumber, String date0fBirth) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.setDate0fBirth(date0fBirth);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDate0fBirth() {
        return date0fBirth;
    }

    public void setDate0fBirth(LocalDate date0fBirth) {
        this.date0fBirth = date0fBirth;
    }

    public void setDate0fBirth(String date0fBirth){
        this.date0fBirth = LocalDate.parse(date0fBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.date0fBirth, today);
        return period.getYears();
    }
}
