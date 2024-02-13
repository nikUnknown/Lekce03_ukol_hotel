import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.ja.hotel.Booking;
import static com.ja.hotel.BookingManager.addBooking;

public class Main {

    public static void main(String[] args) {


        fillBookings();

        //Creating new bookings

        addBooking(3,"Karel","Dvorak",LocalDate.of(1990,5,15),
                LocalDate.of(2023,6,1),LocalDate.of(2023,6,7),false);

        addBooking(2,"Karel","Dvorak",LocalDate.of(1979,1,3),
                LocalDate.of(2023,7,18),LocalDate.of(2023,7,21),true);

        System.out.println("");

    }

    public static void fillBookings() {
        addBooking(3,"Karel","Dvorak",LocalDate.of(1990,5,15),
                LocalDate.of(2023,6,1),LocalDate.of(2023,6,7),false);;


        addBooking(2,"Karel","Dvorak",LocalDate.of(1979,1,3),
                LocalDate.of(2023,7,18),LocalDate.of(2023,7,21),true);


        for(int i= 0; i < 20; i=i+2){
            LocalDate firstCheckIn = LocalDate.of(2024, 8, 1);
            LocalDate firstCheckOut = LocalDate.of(2024,8,2);
            LocalDate checkIn = firstCheckIn.plusDays(i);
            LocalDate checkOut = firstCheckOut.plusDays(i);

            addBooking(2,"Karolina","Tmava",LocalDate.of(1987,4,9),
                    checkIn,checkOut,true);

            System.out.println(checkIn+" "+checkOut);



        }
    }

    public static void printAllBookings(){



    }

}