package com.example.quanlysanpham3.service;

import com.example.quanlysanpham3.dto.product.ProductDetailDto;
import com.example.quanlysanpham3.dto.product.ProductListDto;
import com.example.quanlysanpham3.model.request.CreateProductRequest;
import com.example.quanlysanpham3.model.request.FindProductRequest;
import com.example.quanlysanpham3.model.request.UpdateProductRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

public interface ProductService {
    // get product custom
    Page<ProductListDto> getProductResponse(FindProductRequest req);

    // create product
    Boolean create(@Valid CreateProductRequest request);

    // get product detail
    ProductDetailDto getProductDetail(Long req);

    // update product
    Boolean updateProductRequest(UpdateProductRequest updateProductRequest);

    // delete product
    String deleteProduct(Long id);
}
