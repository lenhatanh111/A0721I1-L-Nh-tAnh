package com.example.demo.controller;

import com.example.demo.dto.ContractDetailDto;
import com.example.demo.dto.ContractDto;
import com.example.demo.model.AttachService;
import com.example.demo.model.Contract;
import com.example.demo.model.ContractDetail;
import com.example.demo.service.AttachServiceService;
import com.example.demo.service.ContractDetailService;
import com.example.demo.service.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private AttachServiceService attachServiceService;
    @Autowired
    private ContractDetailService service;
    @Autowired
    private ContractService contractService;
@ModelAttribute("attachServiceList")
public List<AttachService> setAttachService(){
    List<AttachService> attachServices=attachServiceService.findAll();
    return attachServices;
}
    @ModelAttribute("contractList")
    public List<Contract> setContract(){
        List<Contract> contracts=contractService.getAll();
        return contracts;
    }
    @GetMapping("")
    public String selectAllContractDetail(@PageableDefault(size = 2) Pageable pageable, Model model){
        Page<ContractDetail> contractDetails=service.findAll(pageable);
        model.addAttribute("contractDetails",contractDetails);
        return "/contractDetailList";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        return "/contractDetailCreate";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model){
    if (bindingResult.hasFieldErrors()){
        return "/contractDetailCreate";
    }else {
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        service.save(contractDetail);
        return "redirect:/contractDetail";
    }

    }
}
