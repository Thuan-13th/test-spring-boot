package com.example.quanlysanpham3.repository;

import com.example.quanlysanpham3.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    Optional<Brand> findByBrandName(String brandName);
}
