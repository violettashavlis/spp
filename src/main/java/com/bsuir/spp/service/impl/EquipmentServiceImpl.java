package com.bsuir.spp.service.impl;

import com.bsuir.spp.model.Equipment;
import com.bsuir.spp.repository.EquipmentRepository;
import com.bsuir.spp.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepository repository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Equipment create(Equipment s) {
        return repository.save(s);
    }

    @Override
    public Equipment findById(Integer id) {
        Optional<Equipment> Equipment = repository.findById(id);
        return Equipment.orElse(null);
    }

    @Override
    public List<Equipment> findAll() {
        List<Equipment> list = new ArrayList<>();
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
