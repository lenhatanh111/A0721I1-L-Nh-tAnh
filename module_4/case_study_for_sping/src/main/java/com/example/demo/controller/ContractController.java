package com.example.demo.controller;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.ServiceDto;
import com.example.demo.model.Contract;
import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import com.example.demo.model.Service;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ServiceService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService service;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServiceService serviceService;
    @ModelAttribute("customerList")
    public List<Customer> setCustomer(){
        List<Customer> customers=customerService.findAllCustomer();
        return customers;
    }
    @ModelAttribute("employeeList")
    public List<Employee> setEmployee(){
        List<Employee> employees=employeeService.findAll();
        return employees;
    }
    @ModelAttribute("serviceList")
    public List<Service> setService(){
        List<Service> services=serviceService.getAll();
        return services;
    }
    @GetMapping("")
    public String selectAllContract(@PageableDefault(size = 2) Pageable pageable, Model model){
        Page<Contract> contracts=service.findAll(pageable);
        model.addAttribute("contracts",contracts);
        return "contractList";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("contractDto",new ContractDto());
        return "/contractCreate";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "/contractCreate";
        }else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            service.save(contract);
            return "redirect:/contract";
        }
    }
}
