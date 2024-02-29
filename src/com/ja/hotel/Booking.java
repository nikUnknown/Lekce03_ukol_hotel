package com.ja.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class Booking {

    private int bookingNo;
    private Room room;
    private List<Guest> guests = new ArrayList<>();
    private LocalDate checkIn;
    private LocalDate checkOut;
    private boolean isVacation;
    private int nights;


    //Konstruktor
    public Booking(int bookingNo, Room room, List<Guest> guests, LocalDate checkIn, LocalDate checkOut, boolean isVacation) {
        this.bookingNo = bookingNo;
        this.room = room;
        this.guests = guests;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.isVacation = isVacation;
        this.nights = (int) ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    /*
    public Booking() {
        this(1,RoomManager.getRoomByNo(1),new ArrayList<>(),LocalDate.now(),LocalDate.MAX,true);
    }


    public void setBooking(int bookingNo, Room room, Guest guest, LocalDate checkIn, LocalDate checkOut, boolean isVacation){
        this.bookingNo = bookingNo;
        this.room = room;
        this.guests.add(guest);
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.isVacation = isVacation;
        this.nights = (int) ChronoUnit.DAYS.between(checkIn, checkOut);

    }

     */

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

    /*
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

        return booking;
    }
     */

    public int getNumberOfGuests(){
        return guests.size();
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

}
