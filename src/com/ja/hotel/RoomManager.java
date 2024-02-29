package com.ja.hotel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    static List<Room> rooms = new ArrayList<>();

    static public List<Room> createRooms() {

        // Vytvoření různých pokojů a jejich přidání do seznamu
        rooms.add( new Room(1,1,true,true, BigDecimal.valueOf(1000)));
        rooms.add(new Room(2,1,true,true,BigDecimal.valueOf(1000)));
        rooms.add(new Room(3,3,false,true,BigDecimal.valueOf(2400)));

        return rooms;
    }

    public static Room getRoomByNo(int roomNo) {
        for (Room r : rooms) {
            if (r.getRoomNo() == roomNo) {
                return r;
            }
        }

        return null;
    }
}
