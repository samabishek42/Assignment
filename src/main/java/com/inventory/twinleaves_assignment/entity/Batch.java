package com.inventory.twinleaves_assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "batches")
@Data// I used for create constructors,getter,setters
public class Batch{

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int batchId;

      private int mrp;

      private int sp;

      private int purchasePrice;

      private int availableQuantity;

      private LocalDate inwardedOn;

      @ManyToOne
      @JoinColumn(name = "gtin_id")
      @JsonIgnore
      private Gtin gtin;

}
