package com.example.demo.dto;

import com.example.demo.model.AttachService;
import com.example.demo.model.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
public interface SelectAllCustomerDto {
    int getId();
    String getCustomer_Name();
    Date getCustomer_Birthday();
    String getCustomer_Email();
    boolean getCustomer_Gender();
    String getCustomer_Id_Card();
    String getCustomer_Phone();
    String getCustomer_Address();
    String getCustomer_Type_Name();
    double getContract_Deposit();
    double getContract_Total_Money();
    Date getContract_Start_Date();
    Date getContract_End_Date();
    int getQuantity();
    String getAttach_Service_Name();

}
