package com.example.quanlysanpham3.service;

import com.example.quanlysanpham3.entity.Product;
import com.example.quanlysanpham3.model.request.CreateProductRequest;
import com.example.quanlysanpham3.model.response.GetDetailProductResponse;
import com.example.quanlysanpham3.model.response.GetProductResponse;

import java.util.List;

public interface TestService {

    // get all oke
    List<GetProductResponse> getProductResponse();

    // get product by id
    Product getProductById(Long id);

    // get details product
    List<GetDetailProductResponse> getDetailProoductResponse();

    // tao san pham
    Product createProductRequest(CreateProductRequest request);
}
