package com.bsuir.spp.service;

import com.bsuir.spp.model.Certificate;

import java.util.List;

public interface CertificateService {
    Certificate create(Certificate s);

    Certificate findById(Integer id);

    List<Certificate> findAll();

    boolean deleteById(Integer id);
}
