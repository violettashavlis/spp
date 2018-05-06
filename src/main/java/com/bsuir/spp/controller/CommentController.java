package com.bsuir.spp.controller;

import com.bsuir.spp.model.Comment;
import com.bsuir.spp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<Comment> create(@RequestBody Comment s){
        return ResponseEntity.ok(service.create(s));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Comment>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(service.deleteById(id));
    }
}