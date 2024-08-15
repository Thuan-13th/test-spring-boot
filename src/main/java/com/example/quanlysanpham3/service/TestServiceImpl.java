package com.example.quanlysanpham3.service;

import com.example.quanlysanpham3.entity.Brand;
import com.example.quanlysanpham3.entity.Product;
import com.example.quanlysanpham3.entity.SubCategory;
import com.example.quanlysanpham3.model.request.CreateProductRequest;
import com.example.quanlysanpham3.model.response.GetDetailProductResponse;
import com.example.quanlysanpham3.model.response.GetProductResponse;
import com.example.quanlysanpham3.repository.BrandRepository;
import com.example.quanlysanpham3.repository.CategoryRepository;
import com.example.quanlysanpham3.repository.ProductBrandRepository;
import com.example.quanlysanpham3.repository.ProductRepository;
import com.example.quanlysanpham3.repository.StatusRepository;
import com.example.quanlysanpham3.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductBrandRepository productBrandRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<GetProductResponse> getProductResponse() {
        return productRepository.getProductResponse();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<GetDetailProductResponse> getDetailProoductResponse() {
        return productRepository.getDetailProoductResponse();
    }

    @Override
    public Product createProductRequest(CreateProductRequest request) {
        Product product = new Product();
        product.setProduceName(request.getProductName());
        product.setColor(request.getColor());
        product.setSellPrice(request.getSellPrice());
        product.setQuantity(request.getQuantity());
        product.setOriginPrice(request.getOriginPrice());
        productRepository.save(product);

        Brand brand = new Brand();
        brand.setBrandName(request.getBrandName());
        brandRepository.save(brand);

        SubCategory subCategory = new SubCategory();
        subCategory.setSubCateName(request.getSubCateName());
        subCategoryRepository.save(subCategory);

        return null;
    }
}
