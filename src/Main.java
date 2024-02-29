import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ja.hotel.*;

public class Main {


    static BookingManager bookingManager = new BookingManager();

    public static void main(String[] args) {

        System.out.println("BOOKING SYSTEM\n");

        fillBookings();

        bookingManager.printAllBookings();

        bookingManager.printFirstEightVacation();

        bookingManager.printGuestStatistics();

        System.out.println("\n***********");
        System.out.println("Average guests: "+bookingManager.getAverageGuests());
        System.out.println("Business trips: "+bookingManager.getNumberOfWorkingBookings());
        System.out.println("Vacations: "+bookingManager.getNumberOfVacationBookings());


    }

    public static void fillBookings() {

        Guest adela = new Guest("Adela", "Malikova", LocalDate.of(1993, 5, 15));
        Guest jan = new Guest("Jan", "Dvoracek", LocalDate.of(1990, 5, 15));
        Guest karel_1990 = new Guest("Karel", "Dvorak", LocalDate.of(1990, 5, 15));
        Guest karel_1979 = new Guest("Karel", "Dvorak", LocalDate.of(1979, 1, 3));
        Guest karolina = new Guest("Karolina", "Tmava", LocalDate.of(1987, 1, 3));


        List<Guest> guests1 = new ArrayList<>();
        guests1.add(adela);

        List<Guest> guests2 = new ArrayList<>();
        guests2.add(adela);
        guests2.add(jan);

        List<Guest> guests3 = new ArrayList<>();
        guests3.add(karel_1990);

        List<Guest> guests4 = new ArrayList<>();
        guests4.add(karel_1979);

        List<Guest> guests5 = new ArrayList<>();
        guests5.add(karolina);

        bookingManager.addBooking(new Booking(1, // bookingNo
                RoomManager.getRoomByNo(1), // room
                guests1,
                LocalDate.of(2021, 7, 19), // checkIn
                LocalDate.of(2021, 7, 26), // checkOut
                true));

        bookingManager.addBooking(new Booking(2,
                RoomManager.getRoomByNo(3),
                guests2,
                LocalDate.of(2021,9,1),
                LocalDate.of(2021,9,14),
                true));

        bookingManager.addBooking(new Booking(3,
                RoomManager.getRoomByNo(3),
                guests3,
                LocalDate.of(2021,6,1),
                LocalDate.of(2021,6,7),
                false));

        bookingManager.addBooking(new Booking(4,
                RoomManager.getRoomByNo(2),
                guests4,
                LocalDate.of(2021,7,18),
                LocalDate.of(2021,7,21),
                true));

        bookingManager.addBooking(new Booking(5,
                RoomManager.getRoomByNo(3),
                guests5,
                LocalDate.of(2021,8,1),
                LocalDate.of(2021,8,31),
                true));


        //10 rezervaci pro Karolina Tmava
        int book_num=6;
        for(int i= 1; i < 20; i+=2){
            LocalDate checkIn = LocalDate.of(2024, 8, i);
            LocalDate checkOut = LocalDate.of(2024,8,i+1);

            bookingManager.addBooking(new Booking(book_num++,
                    RoomManager.getRoomByNo(2),
                    guests5,
                    checkIn,
                    checkOut,
                    true));
        }

    }


}