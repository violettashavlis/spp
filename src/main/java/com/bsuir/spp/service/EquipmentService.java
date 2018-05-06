package com.bsuir.spp.service;

import com.bsuir.spp.model.Equipment;

import java.util.List;

public interface EquipmentService {
    Equipment create(Equipment s);

    Equipment findById(Integer id);

    List<Equipment> findAll();

    boolean deleteById(Integer id);
}
