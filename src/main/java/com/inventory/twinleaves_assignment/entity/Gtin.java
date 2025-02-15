package com.inventory.twinleaves_assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "gtins")
@Data
public class Gtin{

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;

      private String gtin;

      @OneToOne
      @JoinColumn(name = "product_id")
      @JsonIgnore
      private Product product;

      @OneToMany(mappedBy = "gtin")
      @JsonIgnore
      private List<Batch> batches;

}
