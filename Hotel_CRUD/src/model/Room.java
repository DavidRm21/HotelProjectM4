package model;

import repository.DBQuery;

public class Room {

    private int id;
    private int hotel;
    private String type;
    private float price;
    private int capacity;
    private boolean state;
    private int service;

    public Room() {
    }

    public Room(int id, int hotel, String type, float price, int capacity, boolean state, int service) {
        this.id = id;
        this.hotel = hotel;
        this.type = type;
        this.price = price;
        this.capacity = capacity;
        this.state = state;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

}
