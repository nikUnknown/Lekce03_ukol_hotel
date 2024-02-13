package com.ja.hotel;

import java.time.LocalDate;

public class Guest {

    private String name;
    private String surname;
    private LocalDate dateOfbirth;


    public void setGuest(String name, String surname, LocalDate dateOfbirth){
        this.name = name;
        this.surname = surname;
        this.dateOfbirth = dateOfbirth;
    }

    public Guest getGuest() {
        Guest guest = new Guest();
        guest.setName(name);
        guest.setSurname(surname);
        guest.setDateOfbirth(dateOfbirth);
        return guest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }
}
