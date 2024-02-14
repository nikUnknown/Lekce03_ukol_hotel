package com.ja.hotel;

import java.math.BigDecimal;

public class Room {
    private int roomNo;
    private int beds;
    private boolean withBalcony;
    private boolean seaView;
    private BigDecimal price;

    //Gettery a settery pro atributy tridy Room
    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public boolean isWithBalcony() {
        return withBalcony;
    }

    public void setWithBalcony(boolean withBalcony) {
        this.withBalcony = withBalcony;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    public BigDecimal getPricePerNight() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //Metoda pro zadani udaju o pokoji
    public void setRoom(int roomNo, int beds, boolean withBalcony, boolean seaView, BigDecimal price) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.withBalcony = withBalcony;
        this.seaView = seaView;
        this.price = price;
    }

    public Room getRoom() {
        Room room = new Room();
        room.setRoomNo(roomNo);
        room.setBeds(beds);
        room.setWithBalcony(withBalcony);
        room.setSeaView(seaView);
        room.setPrice(price);

        return room;
    }

    public String getRoomInfo() {
        String info;
        if (withBalcony && seaView) {
            info = "Room with balcony and sea view.";
        } else if (withBalcony) {
            info ="Room with balcony.";
        } else if (seaView) {
            info = "Room with sea view.";
        } else {
            info = "Room without balcony and sea view.";
        }

        return roomNo+beds+info+price+"CZK/per night";
    }

}
