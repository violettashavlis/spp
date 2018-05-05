package com.bsuir.spp.service;

import com.bsuir.spp.model.User;

import java.util.List;

public interface UserService {

    User create(User s);

    User findById(Integer id);

    List<User> findAll();

    boolean deleteById(Integer id);
}

