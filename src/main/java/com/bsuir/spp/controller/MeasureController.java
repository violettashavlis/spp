package com.bsuir.spp.controller;

import com.bsuir.spp.model.Measure;
import com.bsuir.spp.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measure")
public class MeasureController {

    private final MeasureService service;

    @Autowired
    public MeasureController(MeasureService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<Measure> create(@RequestBody Measure s){
        return ResponseEntity.ok(service.create(s));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Measure> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Measure>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(service.deleteById(id));
    }
}
