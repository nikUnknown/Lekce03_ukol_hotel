package com.ja.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class Booking {

    private int bookingNo;
    private Room room;
    private int numberOfGuests;
    private List<Guest> guests = new ArrayList<>();
    private LocalDate checkIn;
    private LocalDate checkOut;
    private boolean isVacation;
    private int nights;
    private BigDecimal price;


    public void setBooking(int bookingNo, Room room, int numberOfGuests, Guest guest, LocalDate checkIn, LocalDate checkOut, boolean isVacation, int nights, BigDecimal totalPrice){
        this.bookingNo = bookingNo;
        this.room = room;
        this.numberOfGuests = numberOfGuests;
        this.guests.add(guest);
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.isVacation = isVacation;
        this.nights = nights;
        this.price = totalPrice;

    }

    //Metoda vracejici pocet noci pro danou rezervaci
    public long getBookingLength(){
        return ChronoUnit.DAYS.between(checkIn, checkOut);

    }

    //Metoda vracejici celkovou cenu pro jednotlive rezervace
    public BigDecimal getTotalPrice() {
        long nights = getBookingLength();
        BigDecimal price = room.getPricePerNight();
        return price.multiply(BigDecimal.valueOf(nights));
    }

    public Booking getBooking(){
        Booking booking = new Booking();
        booking.setBookingNo(bookingNo);
        booking.setRoom(room);
        booking.setNumberOfGuests(numberOfGuests);
        booking.setGuests(guests);
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setVacation(isVacation);
        booking.setNight(nights);
        booking.setPrice(price);

        return booking;
    }

    public int getNumberOfGuest(){
        return numberOfGuests;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public boolean isVacation() {
        return isVacation;
    }

    public void setVacation(boolean vacation) {
        isVacation = vacation;
    }

    public int getNight() {
        return nights;
    }

    public void setNight(int night) {
        this.nights = night;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
