package com.bsuir.spp.controller;

import com.bsuir.spp.model.ServiceEntity;
import com.bsuir.spp.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceService service;

    @Autowired
    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<ServiceEntity> create(@RequestBody ServiceEntity s){
        return ResponseEntity.ok(service.create(s));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<ServiceEntity> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/read")
    public ResponseEntity<List<ServiceEntity>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(service.deleteById(id));
    }
}
