package model;

public class Room {

    private int id;
    private String type;
    private float price;
    private int capacity;
    private boolean state;

    public Room(int id, String type, float price, int capacity, boolean state) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.capacity = capacity;
        this.state = state;
    }

    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public float getPrice() {
        return price;
    }
    public int getCapacity() {
        return capacity;
    }
    public boolean isState() {
        return state;
    }
}
