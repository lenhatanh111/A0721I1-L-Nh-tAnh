package model.bean;

public class Floor {
    private int floor_id;
    private int floor_number;

    public Floor() {
    }

    public Floor(int floor_number) {
        this.floor_number = floor_number;
    }

    public Floor(int floor_id, int floor_number) {
        this.floor_id = floor_id;
        this.floor_number = floor_number;
    }

    public int getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(int floor_id) {
        this.floor_id = floor_id;
    }

    public int getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(int floor_number) {
        this.floor_number = floor_number;
    }
}
