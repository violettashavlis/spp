package com.bsuir.spp.service;

import com.bsuir.spp.model.ServiceEntity;

import java.util.List;

public interface ServiceService {
    ServiceEntity create(ServiceEntity s);

    ServiceEntity findById(Integer id);

    List<ServiceEntity> findAll();

    boolean deleteById(Integer id);
}
