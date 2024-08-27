package com.example.quanlysanpham3.repository;

import com.example.quanlysanpham3.entity.ProductBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand,Long> {
    ProductBrand findByProductId(long productId);
}
