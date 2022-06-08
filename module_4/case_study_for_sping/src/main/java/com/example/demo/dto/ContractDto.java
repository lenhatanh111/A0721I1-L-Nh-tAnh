package com.example.demo.dto;

import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import com.example.demo.model.Service;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ContractDto {
    int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotEmpty
//    @NotBlank
            Date contractStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotEmpty
//    @NotBlank
            Date contractEndDate;

    @Min(0)
    double contractDeposit;

    @Min(0)
    double contractTotalMoney;
//        @NotEmpty
//    @NotBlank
    private Customer customer;
    //    @NotEmpty
//    @NotBlank
    private Employee employee;
    //    @NotEmpty
//    @NotBlank
    private Service service;

    public ContractDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
