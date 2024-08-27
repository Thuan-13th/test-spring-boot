package com.example.quanlysanpham3.repository;

import com.example.quanlysanpham3.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    // Kiem tra brand name da ton tai chua
    boolean existsByBrandName(String brandName);
    // tìm theo brandName

    Optional<Brand> findByBrandName(String brandName);

    boolean existsById(Long id);
}
