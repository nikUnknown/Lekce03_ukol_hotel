package com.ja.hotel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Rooms {

    public static List<Room> Rooms() {

        List<Room> rooms = new ArrayList<>();

        Room room1 = new Room();
        room1.setRoom(1, 1, true, true, BigDecimal.valueOf(1000));
        rooms.add(room1);

        Room room2 = new Room();
        room2.setRoom(2, 1, true, true, BigDecimal.valueOf(1000));
        rooms.add(room2);

        Room room3 = new Room();
        room3.setRoom(3, 3, false, true, BigDecimal.valueOf(2400));
        rooms.add(room3);

        Room room4 = new Room();
        room4.setRoom(4, 2, true, false, BigDecimal.valueOf(2000));
        rooms.add(room4);

        return rooms;
    }

    //Vypis vsech pokoju
        public static void infoAboutRooms(List<Room> rooms) {
        System.out.println("Info about all rooms:");
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
        System.out.println("");
    }
}
