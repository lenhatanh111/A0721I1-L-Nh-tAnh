package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.*;
import com.example.demo.service.DivisionService;
import com.example.demo.service.EducationDegreeService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.PositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationDegreeService degreeService;
    @Autowired
    private DivisionService divisionService;
    @ModelAttribute("positionList")
    public List<Position> setPosition(){
        List<Position> positions=positionService.findAll();
        return positions;
    }
    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> setEducationDegree(){
        List<EducationDegree> educationDegrees=degreeService.findAll();
        return educationDegrees;
    }
    @ModelAttribute("divisionList")
    public List<Division> setDivision(){
        List<Division> divisions=divisionService.findAll();
        return divisions;
    }
    @GetMapping("")
    public String selectAllEmployee(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String address, @PageableDefault(size = 2) Pageable pageable, Model model) {
        Page<Employee> employees = service.getAllEmployee(name, address, pageable);
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("employees", employees);
        return "/employeeList";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        return "/employeeCreate";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "/employeeCreate";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            service.save(employee);
            return "redirect:/employee";
        }
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        service.delete(id);
        return "redirect:/employee";
    }
    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable int id,Model model){
        Employee employee=service.findById(id);
        EmployeeDto employeeDto=new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        return "/employeeEdit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Validated EmployeeDto employeeDto,BindingResult bindingResult,@RequestParam("id") int id){
        if (bindingResult.hasFieldErrors()){
            return "/employeeEdit";
        }else {
        Employee employee=service.findById(id);
        BeanUtils.copyProperties(employeeDto, employee);
        service.save(employee);
        return "redirect:/employee";
    }}
}
