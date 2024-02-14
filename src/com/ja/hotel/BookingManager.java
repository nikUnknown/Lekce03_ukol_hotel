package com.ja.hotel;

import com.ja.hotel.Booking;
import com.ja.hotel.Guest;
import com.ja.hotel.Room;
import com.ja.hotel.Rooms;

import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d. M. yyyy");
    List<Booking> bookings = new ArrayList<>();
    List<Room> rooms = new Rooms().createRooms();
    List<Guest> guests = new ArrayList<>();


    //metoda pro vlozeni rezervace do seznamu bookings
    public void addBooking(int roomNo, String name, String surname, LocalDate dateOfBirth, LocalDate checkIn, LocalDate checkOut,
                           boolean isVacation, BigDecimal totalPrice) {
        Booking booking = new Booking();
        Guest guest = new Guest();
        guest.setGuest(name, surname, dateOfBirth);
        booking.setGuests(List.of(guest));
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setVacation(isVacation);
        booking.setTotalPrice(totalPrice);

        bookings.add(booking);
    }


    //metoda pro ziskani rezervace se zadanym indexem seznamu
    public Booking getBooking(int index) {
        if ((index >= 0) && (index < bookings.size())) {
            return bookings.get(index);
        }
        System.out.println("No booking found at index");
        return null;
    }

    //metoda pro ziskani seznamu rezervaci
    public List<Booking> getBookings() {
        return bookings;
    }

    //metoda pro vymazani seznamu rezervaci
    public void clearBookings() {
        bookings.clear();
    }

    //metoda ktera vrati pocet rezervaci pro pracovni pobyty
    public int getNumberOfWorkingBookings(List<Booking> bookings) {
        int workingBookings = 0;
        for (Booking booking : bookings) {
            if (!booking.isVacation()) {
                workingBookings++;
            }
        }
        return workingBookings;
    }

    public int getNumberOfVacationBookings(List<Booking> bookings) {
        int vacationBookings = 0;
        for (Booking booking : bookings) {
            if (booking.isVacation()) {
                vacationBookings += booking.getNumberOfGuest();
            }
        }
        return vacationBookings;
    }

    //metoda ktera vrati prumerny pocet hostu na rezervaci
    public double getAverageGuests(List<Booking> bookings) {
        int totalGuests = 0;
        int totalBookings = 0;

        for (Booking booking : bookings) {
            totalGuests += booking.getNumberOfGuest();
        }

        if (totalBookings == 0) {
            return 0;
        } else {
            return (double) totalGuests / totalBookings;
        }

    }

    //2023-06-01 až 2023-06-05: Alena Krásová (1993-05-18)[2, ano] za 4000 Kč
    public void printAllBookings() {
        System.out.println("List of all bookings:");
        bookings.forEach(booking -> {
            var checkInFormat = booking.getCheckIn().format(dateTimeFormatter);
            var checkOutFormat = booking.getCheckOut().format(dateTimeFormatter);
            System.out.printf("%s to %s: \n", checkInFormat, checkOutFormat);
        });

    }

    public List<Booking> printFirstEightVacation() {
        System.out.println("\nList of first eight vacation bookings:");
        int count = 0;
        for (Booking booking : bookings) {
            if (count >= 8) {
                break; // Ukončení smyčky jakmile je nacten 8.booking kde isVacation=true
            }
            if (booking.isVacation()) {
                booking.getGuests().forEach(guest -> {
                    System.out.printf("%s - %s :%s %s (%s)[%d, %s] za %s Kč\n",
                            booking.getCheckIn(), booking.getCheckOut(), guest.getName(), guest.getSurname(), guest.getDateOfBirth().format(dateTimeFormatter),
                            booking.getNumberOfGuest(), booking.isVacation() ? "ano" : "ne", booking.getTotalPrice())
                    ;
                });

                count++;
            }
        }
        return null;
    }

    /*
    public List<Booking> printGuestStatistics(){
        System.out.println("\nGuest statistics:");
        int numberOfGuest = 0;
    */


}
