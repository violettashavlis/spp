package com.bsuir.spp.service.impl;

import com.bsuir.spp.model.Material;
import com.bsuir.spp.repository.MaterialRepository;
import com.bsuir.spp.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;

    @Autowired
    public MaterialServiceImpl(MaterialRepository repository) {
        this.repository = repository;
    }


    @Override
    public Material create(Material s) {
        Material save = repository.save(s);
        return repository.findById(save.getId()).get();
    }

    @Override
    public Material findById(Integer id) {
        Optional<Material> Material = repository.findById(id);
        return Material.orElse(null);
    }

    @Override
    public List<Material> findAll() {
        List<Material> list = new ArrayList<>();
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
