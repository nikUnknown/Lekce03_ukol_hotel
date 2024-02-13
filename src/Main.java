import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.ja.hotel.Booking;
import com.ja.hotel.BookingManager;

public class Main {


    static BookingManager bookingManager = new BookingManager();

    public static void main(String[] args) {


        fillBookings();

        bookingManager.printAllBookings();

    }

    public static void fillBookings() {
        bookingManager.addBooking(3,"Karel","Dvorak",LocalDate.of(1990,5,15),
                LocalDate.of(2023,6,1),LocalDate.of(2023,6,7),false);;


        bookingManager.addBooking(2,"Karel","Dvorak",LocalDate.of(1979,1,3),
                LocalDate.of(2023,7,18),LocalDate.of(2023,7,21),true);


        for(int i= 1; i < 20; i+=2){
            LocalDate checkIn = LocalDate.of(2024, 8, i);
            LocalDate checkOut = LocalDate.of(2024,8,i+1);

            bookingManager.addBooking(2,"Karolina","Tmava",LocalDate.of(1987,4,9),
                    checkIn,checkOut,true);

        }
    }


}