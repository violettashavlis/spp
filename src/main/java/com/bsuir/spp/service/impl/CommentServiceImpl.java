package com.bsuir.spp.service.impl;

import com.bsuir.spp.model.Comment;
import com.bsuir.spp.repository.CommentRepository;
import com.bsuir.spp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    @Autowired
    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Comment create(Comment s) {
        return repository.save(s);
    }

    @Override
    public Comment findById(Integer id) {
        Optional<Comment> Comment = repository.findById(id);
        return Comment.orElse(null);
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @Override
    @Transactional()
    public boolean deleteById(Integer id) {
        repository.deleteById(id);
        return repository.existsById(id);
    }
}
