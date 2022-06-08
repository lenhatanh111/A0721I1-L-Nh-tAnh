package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import com.example.demo.model.User;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
@Autowired
    private CustomerService service;
@Autowired
private CustomerTypeService typeService;
@ModelAttribute("customerTypeList")
public List<CustomerType> setCustomerType(){
    List<CustomerType> customerTypes=typeService.findAll();
    return customerTypes;
}

@GetMapping("")
    public String selectCustomer(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String address, @PageableDefault(size = 2) Pageable pageable, Model model){
    Page<Customer> customers=service.getAllCustomer(name,address,pageable);
    model.addAttribute("name",name);
    model.addAttribute("address",address);
    model.addAttribute("customers",customers);
    return "/customerList";
}
@GetMapping("/create")
    public String showCreateForm(Model model){
model.addAttribute("customerDto",new CustomerDto());
return "/customerCreate";

}
    @PostMapping("/create")
    public String create(@ModelAttribute CustomerDto customerDto, Model model) {

            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            service.save(customer);
            return "redirect:/customer";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        service.delete(id);
        return "redirect:/customer";
    }
   @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable int id,Model model){
    Customer customer=service.findById(id);
    CustomerDto customerDto=new CustomerDto();
       BeanUtils.copyProperties(customer, customerDto);
       model.addAttribute("customerDto",customerDto);
    return "/customerEdit";
   }
   @PostMapping("/update")
    public String update(@ModelAttribute CustomerDto customerDto,@RequestParam("id") int id){
    Customer customer=service.findById(id);
       BeanUtils.copyProperties(customerDto, customer);
       service.save(customer);
       return "redirect:/customer";
   }
}
