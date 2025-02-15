package com.inventory.twinleaves_assignment.service;

import com.inventory.twinleaves_assignment.entity.Batch;
import com.inventory.twinleaves_assignment.entity.Gtin;
import com.inventory.twinleaves_assignment.entity.Product;
import com.inventory.twinleaves_assignment.repository.BatchRepository;
import com.inventory.twinleaves_assignment.repository.GtinRepository;
import com.inventory.twinleaves_assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InventoryService {

      @Autowired
      private ProductRepository productRepo;

      @Autowired
      private GtinRepository gtinRepo;

      @Autowired
      private BatchRepository batchRepo;

      public String create() {

            Product product = new Product();
            product.setProductName("Product1");
            product.setCreatedOn(LocalDate.now());
            productRepo.save(product);

            Gtin gtin = new Gtin();
            gtin.setGtin("G1");
            gtin.setProduct(product);
            gtinRepo.save(gtin);

            Batch batch1 = new Batch();
            batch1.setMrp(100);
            batch1.setSp(90);
            batch1.setPurchasePrice(70);
            batch1.setAvailableQuantity(100);
            batch1.setInwardedOn(LocalDate.now());
            batch1.setGtin(gtin);
            batchRepo.save(batch1);

            return "created successfully";
      }

      public List<Batch> getBatchesByGtin(String gtin) {
            return batchRepo.findByGtin_Gtin(gtin);
      }


      public List<String> getPositiveBatchesByGtins() {
            return batchRepo.fetchAvailableGtins();
      }

      public List<Batch> getLatestNegativeOrZeroBatches() {
            return batchRepo.findLatestZeroOrNegativeBatches();
      }


}

