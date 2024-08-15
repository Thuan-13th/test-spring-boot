package com.example.quanlysanpham3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subcate_id")
    private Long subcateId;

    @Column(name = "produce_name")
    private String produceName;

    private String color;
    private Long quantity;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name = "origin_price")
    private Double originPrice;

    private String description;

    @Column(name = "status_id")
    private Long statusId;
}
