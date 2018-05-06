package com.bsuir.spp.service;

import com.bsuir.spp.model.Comment;

import java.util.List;

public interface CommentService {
    Comment create(Comment s);

    Comment findById(Integer id);

    List<Comment> findAll();

    boolean deleteById(Integer id);
}
