package com.example.demo.controller;

import com.example.demo.dto.ServiceDto;
import com.example.demo.model.RentType;
import com.example.demo.model.Service;
import com.example.demo.model.ServiceType;
import com.example.demo.service.RentTypeService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.ServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
private ServiceService serviceService;
    @Autowired
    private RentTypeService rentTypeService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @ModelAttribute("rentTypeList")
    public List<RentType> setRentType(){
        List<RentType> rentTypes=rentTypeService.findAll();
        return rentTypes;
    }
    @ModelAttribute("serviceTypeList")
    public List<ServiceType> setServiceType(){
        List<ServiceType> serviceTypes=serviceTypeService.findAll();
        return serviceTypes;
    }
    @GetMapping("")
    public String selectAllService(@PageableDefault(size = 2) Pageable pageable, Model model){
        Page<Service> services=serviceService.findAll(pageable);
        model.addAttribute("services",services);
        return "/serviceList";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("serviceDto",new ServiceDto());
        return "/serviceCreate";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute ServiceDto serviceDto,Model model){
        Service service=new Service();
        BeanUtils.copyProperties(serviceDto, service);
        serviceService.save(service);
        return "redirect:/service";

    }
}
