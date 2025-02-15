package com.inventory.twinleaves_assignment.controller;

import com.inventory.twinleaves_assignment.entity.Batch;
import com.inventory.twinleaves_assignment.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

      @Autowired
      private InventoryService inventoryService;

      @PostMapping("/create")
      public ResponseEntity<String> createData() {
            try {
                  String result = inventoryService.create();
                  return new ResponseEntity<>(result, HttpStatus.OK);
            } catch (Exception e) {
                  return new ResponseEntity<>("failed to create" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
      }

      @GetMapping("/gtin/{gtin}")
      public ResponseEntity<List<Batch>> getBatchesByGtin(@PathVariable String gtin) {
            try {
                  List<Batch> batches = inventoryService.getBatchesByGtin(gtin);
                  if (batches.isEmpty()) {
                        return new ResponseEntity<>(batches, HttpStatus.NOT_FOUND);
                  }
                  return new ResponseEntity<>(batches, HttpStatus.OK);
            } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
      }

      @GetMapping("/getAllGtinsPositive")
      public ResponseEntity<List<String>> getPositiveGtinBatches() {
            try {
                  List<String> gtins = inventoryService.getPositiveBatchesByGtins();
                  if (gtins.isEmpty()) {
                        return new ResponseEntity<>(gtins, HttpStatus.NOT_FOUND);
                  }
                  return new ResponseEntity<>(gtins, HttpStatus.OK);
            } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
      }

      @GetMapping("/latestBatches")
      public ResponseEntity<List<Batch>> getLatestBatches() {
            try {
                  List<Batch> batches = inventoryService.getLatestNegativeOrZeroBatches();
                  if (batches.isEmpty()) {
                        return new ResponseEntity<>(batches, HttpStatus.NOT_FOUND);
                  }
                  return new ResponseEntity<>(batches, HttpStatus.OK);
            } catch (Exception e) {
                  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
      }
}
