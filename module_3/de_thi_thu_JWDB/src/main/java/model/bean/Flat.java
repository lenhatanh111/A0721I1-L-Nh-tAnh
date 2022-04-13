package model.bean;

public class Flat {
    private int flat_id;
    private int status_id;
    private int area;
    private int floor;
    private int flat_type_id;
    private double cost;
    private String start_date;
    private String end_date;
    private String description;

    public Flat() {
    }

    public Flat(int flat_id, int status_id, int area, int floor, int flat_type_id, double cost, String start_date, String end_date, String description) {
        this.flat_id = flat_id;
        this.status_id = status_id;
        this.area = area;
        this.floor = floor;
        this.flat_type_id = flat_type_id;
        this.cost = cost;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }

    public Flat(int status_id, int area, int floor, int flat_type_id, double cost, String start_date, String end_date, String description) {
        this.status_id = status_id;
        this.area = area;
        this.floor = floor;
        this.flat_type_id = flat_type_id;
        this.cost = cost;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }

    public int getFlat_id() {
        return flat_id;
    }

    public void setFlat_id(int flat_id) {
        this.flat_id = flat_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFlat_type_id() {
        return flat_type_id;
    }

    public void setFlat_type_id(int flat_type_id) {
        this.flat_type_id = flat_type_id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
