package com.bsuir.spp.service.impl;

import com.bsuir.spp.model.Certificate;
import com.bsuir.spp.repository.CertificateRepository;
import com.bsuir.spp.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService{
    private final CertificateRepository repository;

    @Autowired
    public CertificateServiceImpl(CertificateRepository repository) {
        this.repository = repository;
    }


    @Override
    public Certificate create(Certificate s) {
        return repository.save(s);
    }

    @Override
    public Certificate findById(Integer id) {
        Optional<Certificate> Certificate = repository.findById(id);
        return Certificate.orElse(null);
    }

    @Override
    public List<Certificate> findAll() {
        List<Certificate> list = new ArrayList<>();
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
