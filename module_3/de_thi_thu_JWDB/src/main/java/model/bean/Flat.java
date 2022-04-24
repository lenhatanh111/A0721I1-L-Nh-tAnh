package model.bean;

public class Flat {
    private String flat_id;
    private String status_name;
    private int status_id;
    private int area;
    private int floor;
    private String flat_type_name;
    private int flat_type_id;
    private double cost;
    private String start_date;
    private String end_date;
    private String description;



    public Flat() {
    }

    public Flat(String flat_id, String status_name, int area, int floor, String flat_type_name, double cost, String start_date, String end_date, String description) {
        this.flat_id = flat_id;
        this.status_name = status_name;
        this.area = area;
        this.floor = floor;
        this.flat_type_name = flat_type_name;
        this.cost = cost;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }

    public Flat(String flat_id, int status_id, int area, int floor, int flat_type_id, double cost, String start_date, String end_date, String description) {
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

    public String getFlat_id() {
        return flat_id;
    }

    public void setFlat_id(String flat_id) {
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

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public String getFlat_type_name() {
        return flat_type_name;
    }

    public void setFlat_type_name(String flat_type_name) {
        this.flat_type_name = flat_type_name;
    }
}
