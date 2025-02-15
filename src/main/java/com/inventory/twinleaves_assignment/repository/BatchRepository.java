package com.inventory.twinleaves_assignment.repository;

import com.inventory.twinleaves_assignment.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, Integer> {

      List<Batch> findByGtin_Gtin(String gtin);


      @Query("SELECT DISTINCT b.gtin.gtin FROM Batch b WHERE b.availableQuantity > 0")
      List<String> fetchAvailableGtins();


      @Query("""
        SELECT b FROM Batch b
        WHERE b.availableQuantity <= 0
        AND b.inwardedOn = (
            SELECT MAX(b2.inwardedOn) FROM Batch b2
            WHERE b2.gtin.id = b.gtin.id
            AND b2.availableQuantity <= 0
        )
    """)
      List<Batch> findLatestZeroOrNegativeBatches();

}
