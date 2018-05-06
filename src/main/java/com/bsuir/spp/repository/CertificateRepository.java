package com.bsuir.spp.repository;

import com.bsuir.spp.model.Certificate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends CrudRepository<Certificate,Integer>{
}
