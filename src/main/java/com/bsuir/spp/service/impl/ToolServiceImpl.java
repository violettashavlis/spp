package com.bsuir.spp.service.impl;

import com.bsuir.spp.model.Tool;
import com.bsuir.spp.repository.ToolRepository;
import com.bsuir.spp.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToolServiceImpl implements ToolService{

    private final ToolRepository repository;

    @Autowired
    public ToolServiceImpl(ToolRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tool create(Tool s) {
        return repository.save(s);
    }

    @Override
    public Tool findById(Integer id) {
        Optional<Tool> Tool = repository.findById(id);
        return Tool.orElse(null);
    }

    @Override
    public List<Tool> findAll() {
        List<Tool> list = new ArrayList<>();
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
