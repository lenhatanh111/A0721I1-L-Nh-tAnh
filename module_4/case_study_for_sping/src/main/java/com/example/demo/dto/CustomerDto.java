package com.example.demo.dto;

import com.example.demo.model.Contract;
import com.example.demo.model.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

public class CustomerDto {
    private int id;
    @NotEmpty
    @NotBlank
    private String customerName;
//    @NotEmpty
//    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerBirthday;
//    @NotEmpty
//    @NotBlank
    private boolean customerGender;
    @NotEmpty
    @NotBlank
@Pattern(regexp = "^\\d{9}|\\d{12}$",message = "sai dinh dang cmnd")
    private String customerIdCard;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",message = "sai dinh dang sdt")
    private String customerPhone;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message = "sai định đạng email")
    private String customerEmail;
    @NotEmpty
    @NotBlank
    private String customerAddress;
//    @NotEmpty
//    @NotBlank
    private CustomerType customerType;
//    List<Contract> contracts;

    public CustomerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

//    public List<Contract> getContracts() {
//        return contracts;
//    }
//
//    public void setContracts(List<Contract> contracts) {
//        this.contracts = contracts;
//    }
}
