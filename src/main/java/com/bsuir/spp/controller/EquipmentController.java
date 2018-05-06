package com.bsuir.spp.controller;

import com.bsuir.spp.model.Equipment;
import com.bsuir.spp.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipment")
public class EquipmentController {

    private final EquipmentService service;

    @Autowired
    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<Equipment> create(@RequestBody Equipment s){
        return ResponseEntity.ok(service.create(s));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Equipment> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Equipment>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(service.deleteById(id));
    }
}
