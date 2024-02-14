package com.ja.hotel;

import java.time.LocalDate;

public class Guest {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;


    public void setGuest(String name, String surname, LocalDate dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Guest getGuest() {
        Guest guest = new Guest();
        guest.setName(name);
        guest.setSurname(surname);
        guest.setDateOfBirth(dateOfBirth);
        return guest;
    }
//Alena Krásová (1993-05-18)
    @Override
    public String toString() {
        return name+" "+surname+" ("+dateOfBirth+")";
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
