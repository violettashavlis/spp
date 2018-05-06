package com.bsuir.spp.repository;

import com.bsuir.spp.model.Tool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends CrudRepository<Tool,Integer> {
}
