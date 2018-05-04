package com.bsuir.spp.service.impl;

import com.bsuir.spp.model.ServiceEntity;
import com.bsuir.spp.repository.ServiceRepository;
import com.bsuir.spp.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceEntity create(ServiceEntity s){
        return repository.save(s);
    }


    @Override
    public ServiceEntity findById(Integer id){
        Optional<ServiceEntity> entity = repository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }else{
            return null;
        }
    }

    @Override
    public List<ServiceEntity> findAll(){
        List<ServiceEntity> list = new ArrayList<>();
        repository.findAll().forEach((data)->list.add(data));
        return list;
    }

    @Override
    public boolean deleteById(Integer id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
