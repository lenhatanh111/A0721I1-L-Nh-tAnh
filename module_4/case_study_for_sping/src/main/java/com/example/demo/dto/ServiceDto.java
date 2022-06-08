package com.example.demo.dto;

import com.example.demo.model.RentType;
import com.example.demo.model.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class ServiceDto {
    private int id;
    @NotEmpty
    @NotBlank
    private String serviceName;

    @Min(0)
    private int serviceArea;

    @Min(0)
    private double serviceCost;

    @Min(0)
    private int serviceMaxPeople;
    @NotEmpty
    @NotBlank
    private String standardRoom;
    @NotEmpty
    @NotBlank
    private String descriptionOtherConvenience;

    @Min(0)
    private double poolArea;

    private int numberOfFloors;
//    @NotEmpty
//    @NotBlank
    private RentType rentType;
//    @NotEmpty
//    @NotBlank
    private ServiceType serviceType;

    public ServiceDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
