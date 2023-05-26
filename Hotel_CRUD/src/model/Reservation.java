package model;

public class Reservation {

    private int id;
    private int client_id;
    private int room_id;
    private String startDate;
    private String EndDate;

    public Reservation() {
    }

    public Reservation(int id, int client_id, int room_id, String startDate, String endDate) {
        this.id = id;
        this.client_id = client_id;
        this.room_id = room_id;
        this.startDate = startDate;
        EndDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }
}
