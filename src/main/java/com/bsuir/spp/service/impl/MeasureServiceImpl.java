package com.bsuir.spp.service.impl;

import com.bsuir.spp.model.Measure;
import com.bsuir.spp.repository.MeasureRepository;
import com.bsuir.spp.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeasureServiceImpl implements MeasureService {
    private final MeasureRepository repository;

    @Autowired
    public MeasureServiceImpl(MeasureRepository repository) {
        this.repository = repository;
    }


    @Override
    public Measure create(Measure s) {
        return repository.save(s);
    }

    @Override
    public Measure findById(Integer id) {
        Optional<Measure> Measure = repository.findById(id);
        return Measure.orElse(null);
    }

    @Override
    public List<Measure> findAll() {
        List<Measure> list = new ArrayList<>();
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
