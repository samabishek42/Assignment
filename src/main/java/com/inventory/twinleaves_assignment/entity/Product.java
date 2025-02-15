package com.inventory.twinleaves_assignment.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "products")
@Data
public class Product {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int productId;

      private String productName;

      private LocalDate createdOn;

      @OneToOne(mappedBy = "product")
      @JsonIgnore
      private Gtin gtin;
}

