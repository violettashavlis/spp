package com.bsuir.spp.controller;


import com.bsuir.spp.model.Material;
import com.bsuir.spp.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    private final MaterialService service;

    @Autowired
    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<Material> create(@RequestBody Material s){
        return ResponseEntity.ok(service.create(s));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Material> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Material>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(service.deleteById(id));
    }
}