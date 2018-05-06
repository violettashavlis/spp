package com.bsuir.spp.service;

import com.bsuir.spp.model.Material;

import java.util.List;

public interface MaterialService {

    Material create(Material s);

    Material findById(Integer id);

    List<Material> findAll();

    boolean deleteById(Integer id);
}
