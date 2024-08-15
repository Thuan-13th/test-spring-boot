package com.example.quanlysanpham3.service;

import com.example.quanlysanpham3.entity.SubCategory;
import com.example.quanlysanpham3.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SubCategoryServiceImpl implements SubCategoryService{
    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategory getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id).get();
    }
}
