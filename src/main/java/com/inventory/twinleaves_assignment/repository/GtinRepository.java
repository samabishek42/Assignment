package com.inventory.twinleaves_assignment.repository;

import com.inventory.twinleaves_assignment.entity.Gtin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GtinRepository extends JpaRepository<Gtin,Integer> {

}
