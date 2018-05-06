package com.bsuir.spp.service;

import com.bsuir.spp.model.Measure;

import java.util.List;

public interface MeasureService {

    Measure create(Measure s);

    Measure findById(Integer id);

    List<Measure> findAll();

    boolean deleteById(Integer id);
}
