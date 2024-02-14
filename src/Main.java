import java.math.BigDecimal;
import java.time.LocalDate;
import com.ja.hotel.BookingManager;

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

        bookingManager.addBooking(1,1,"Adela","Malikova",LocalDate.of(1993,3,13),
                LocalDate.of(2021,7,19),LocalDate.of(2021,7,26),false,BigDecimal.valueOf(1000));

        bookingManager.addBooking(3,2,"Jan","Dvorak",LocalDate.of(1995,5,5),
                LocalDate.of(2021,9,1),LocalDate.of(2021,9,14),true,BigDecimal.valueOf(2400));

        bookingManager.addBooking(3,1, "Karel","Dvorak",LocalDate.of(1990,5,15),
                LocalDate.of(2023,6,1),LocalDate.of(2023,6,7),false, BigDecimal.valueOf(2400));;

        bookingManager.addBooking(2,1,"Karel","Dvorak",LocalDate.of(1979,1,3),
                LocalDate.of(2023,7,18),LocalDate.of(2023,7,21),true, BigDecimal.valueOf(1000));


        for(int i= 1; i < 20; i+=2){
            LocalDate checkIn = LocalDate.of(2024, 8, i);
            LocalDate checkOut = LocalDate.of(2024,8,i+1);

            bookingManager.addBooking(2,1, "Karolina","Tmava",LocalDate.of(1987,4,9),
                    checkIn,checkOut,true, BigDecimal.valueOf(1000));

        }
    }


}