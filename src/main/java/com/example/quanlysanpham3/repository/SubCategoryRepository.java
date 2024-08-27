package com.example.quanlysanpham3.repository;

import com.example.quanlysanpham3.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    // kiem tra SubCategoryRepository co ton tai khong
    boolean existsBySubCateName(String cateName);
    // tìm theo tên subcateName
    Optional<SubCategory> findBySubCateName(String subCateName);
}
