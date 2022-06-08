package com.example.demo.dto;

import com.example.demo.model.AttachService;
import com.example.demo.model.Contract;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ContractDetailDto {
    int id;

    @Min(0)
    int quantity;
//    @NotEmpty
//    @NotBlank
    private Contract contract;
//    @NotEmpty
//    @NotBlank
    private AttachService attachService;

    public ContractDetailDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
