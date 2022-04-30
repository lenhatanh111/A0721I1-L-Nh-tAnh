package com.codegym.entity;

public class Declaration {
    String id;
    String name;
    String birthday;
    boolean gender;
    String nationality;
    String id_card;
    String vehicle;
    String vehicle_id;
    String seats;
    String start_day;
    String start_month;
    String start_year;
    String end_day;
    String end_month;
    String end_year;
    String travel_history;

    public Declaration() {
    }

    public Declaration(String id,String name, String birthday, boolean gender, String nationality, String id_card, String vehicle, String vehicle_id, String seats, String start_day, String start_month, String start_year, String end_day, String end_month, String end_year, String travel_history) {
        this.id=id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.nationality = nationality;
        this.id_card = id_card;
        this.vehicle = vehicle;
        this.vehicle_id = vehicle_id;
        this.seats = seats;
        this.start_day = start_day;
        this.start_month = start_month;
        this.start_year = start_year;
        this.end_day = end_day;
        this.end_month = end_month;
        this.end_year = end_year;
        this.travel_history = travel_history;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getStart_day() {
        return start_day;
    }

    public void setStart_day(String start_day) {
        this.start_day = start_day;
    }

    public String getStart_month() {
        return start_month;
    }

    public void setStart_month(String start_month) {
        this.start_month = start_month;
    }

    public String getStart_year() {
        return start_year;
    }

    public void setStart_year(String start_year) {
        this.start_year = start_year;
    }

    public String getEnd_day() {
        return end_day;
    }

    public void setEnd_day(String end_day) {
        this.end_day = end_day;
    }

    public String getEnd_month() {
        return end_month;
    }

    public void setEnd_month(String end_month) {
        this.end_month = end_month;
    }

    public String getEnd_year() {
        return end_year;
    }

    public void setEnd_year(String end_year) {
        this.end_year = end_year;
    }

    public String getTravel_history() {
        return travel_history;
    }

    public void setTravel_history(String travel_history) {
        this.travel_history = travel_history;
    }
}
