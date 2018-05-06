package com.bsuir.spp.service;

import com.bsuir.spp.model.Tool;

import java.util.List;

public interface ToolService {

    Tool create(Tool s);

    Tool findById(Integer id);

    List<Tool> findAll();

    boolean deleteById(Integer id);
}
