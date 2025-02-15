package com.inventory.twinleaves_assignment.repository;

import com.inventory.twinleaves_assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
