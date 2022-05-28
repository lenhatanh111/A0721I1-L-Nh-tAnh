package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
       Optional<Smartphone> smartphone = smartphoneService.getById(id);
        if (!smartphone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphone.get(), HttpStatus.NO_CONTENT);
    }
//    @GetMapping("/{id}/update")
//    public public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id)
@GetMapping("/{id}/update")
public ModelAndView getById(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView("/update");
    modelAndView.addObject("smartphone", smartphoneService.findById(id));
    modelAndView.addObject("smartphones", smartphoneService.findAll());
    return modelAndView;
}
//    @PostMapping("/update")
//    public ResponseEntity<Smartphone> update(@RequestBody Smartphone smartphone) {
//        Smartphone smartphone1=smartphoneService.
//        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
//    }
    @PutMapping
    public ResponseEntity<Smartphone> updateSmartphone(@RequestBody Smartphone smartphone) {
        if (smartphone==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.update(smartphone);
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }

}
