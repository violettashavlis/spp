package com.bsuir.spp.repository;

import com.bsuir.spp.model.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material,Integer> {
}
