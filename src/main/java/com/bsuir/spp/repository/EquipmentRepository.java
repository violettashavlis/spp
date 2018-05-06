package com.bsuir.spp.repository;

import com.bsuir.spp.model.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment,Integer> {
}
