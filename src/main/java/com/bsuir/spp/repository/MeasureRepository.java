package com.bsuir.spp.repository;

import com.bsuir.spp.model.Measure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository extends CrudRepository<Measure,Integer> {
}
