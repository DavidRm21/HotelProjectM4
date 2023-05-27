package model;

public class Room {

    private int id;
    private String type;
    private float price;
    private int capacity;
    private boolean state;

    public Room() {
    }

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

    public void setId(int id) {
        this.id = id;
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


}
