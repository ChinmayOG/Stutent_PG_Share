package com.pgshare.studentpgapp;

public class Room {
        private String roomName;
        private String location;
        private double price;
    private int imageResourceId;

    // Constructor and getter methods

        public Room(String roomName, String location, double price,int imageResourceId) {
            this.roomName = roomName;
            this.location = location;
            this.price = price;
            this.imageResourceId = imageResourceId;

        }

        public String getRoomName() {
            return roomName;
        }

        public String getLocation() {
            return location;
        }

        public double getPrice() {
            return price;
        }

    public int getImageResourceId() {
        return imageResourceId;
    }

}
