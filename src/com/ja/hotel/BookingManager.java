package com.ja.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingManager {
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d. M. yyyy");
    List<Booking> bookings = new ArrayList<>();

    public BookingManager() {
        RoomManager.createRooms();
    }

    //metoda pro vlozeni rezervace do seznamu bookings
    public void addBooking(Booking booking) {
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
        return new ArrayList<>(bookings);
    }

    //metoda pro vymazani seznamu rezervaci
    public void clearBookings() {
        bookings.clear();
    }

    //metoda ktera vrati pocet rezervaci pro pracovni pobyty
    public int getNumberOfWorkingBookings() {
        int workingBookings = 0;
        for (Booking booking : bookings) {
            if (!booking.isVacation()) {
                workingBookings++;
            }
        }
        return workingBookings;
    }

    //Metoda vracejici pocet rezervaci kde isVacation=true
    public int getNumberOfVacationBookings() {
        int vacationBookings = 0;
        for (Booking booking : bookings) {
            if (booking.isVacation()) {
                vacationBookings += booking.getNumberOfGuests();
            }
        }
        return vacationBookings;
    }

    //metoda ktera vrati prumerny pocet hostu na rezervaci
    public double getAverageGuests() {
        double totalGuests = 0;
        double totalBookings = 0;

        for (Booking booking : bookings) {
            totalGuests += booking.getNumberOfGuests();
            totalBookings++;
        }

        if (totalBookings == 0) {
            return 0;
        } else {
            return totalGuests / totalBookings;
        }

    }

    //Vypis vsech rezervaci ve formatu - 2023-06-01 až 2023-06-05: Alena Krásová (1993-05-18)[2, ano - seaView] za 4000 Kč
    public void printAllBookings() {
        System.out.println("List of all bookings:");
        bookings.forEach(booking -> {
            var checkInFormat = booking.getCheckIn().format(dateTimeFormatter);
            var checkOutFormat = booking.getCheckOut().format(dateTimeFormatter);
            System.out.printf("%s to %s: %s [%d, %s] for %sCzk\n", checkInFormat, checkOutFormat, booking.getGuests(), booking.getNumberOfGuests(),
                    booking.getRoom().isSeaView() ? "yes" : "no", booking.getTotalPrice());
            System.out.println("Number of nights: "+booking.getBookingLength()+"\n");
        });

    }

    //Vypis prvnich 8 rezervaci kde je typ rezervaca vacation
    public List<Booking> printFirstEightVacation() {
        System.out.println("\nList of first eight vacation bookings:");
        int count = 0;
        for (Booking booking : bookings) {
            if (count >= 8) {
                break; // Ukončení smyčky jakmile je nacten 8.booking kde isVacation=true
            }
            if (booking.isVacation()) {
                booking.getGuests().forEach(guest -> {
                    System.out.printf("%s - %s :%s %s (%s)[%d, %s] for %sCzk\n",
                            booking.getCheckIn(), booking.getCheckOut(), guest.getName(), guest.getSurname(), guest.getDateOfBirth().format(dateTimeFormatter),
                            booking.getNumberOfGuests(), booking.getRoom().isSeaView() ? "yes" : "no", booking.getTotalPrice())
                    ;
                });

                count++;
            }
        }
        return null;
    }

    //Metoda vypisujici statistiky o poctu hostu v ramci rezervace
    public void printGuestStatistics() {
        int bookingsWithOneGuest = 0;
        int bookingsWithTwoGuests = 0;
        int bookingsWithMoreThanTwoGuests = 0;

        for (Booking booking : bookings) {
            int numberOfGuests = booking.getNumberOfGuests();
            if (numberOfGuests == 1) {
                bookingsWithOneGuest++;
            } else if (numberOfGuests == 2) {
                bookingsWithTwoGuests++;
            } else {
                bookingsWithMoreThanTwoGuests++;
            }
        }

        System.out.println("\nGuest Statistics:");
        System.out.printf("Bookings with 1 guest: %d\n", bookingsWithOneGuest);
        System.out.printf("Bookings with 2 guests: %d\n", bookingsWithTwoGuests);
        System.out.printf("Bookings with more than 2 guests: %d\n", bookingsWithMoreThanTwoGuests);
    }


}
