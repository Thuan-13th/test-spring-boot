package com.example.quanlysanpham3.controller;

import com.example.quanlysanpham3.entity.Product;
import com.example.quanlysanpham3.model.request.CreateProductRequest;
import com.example.quanlysanpham3.model.response.GetDetailProductResponse;
import com.example.quanlysanpham3.model.response.GetProductResponse;
import com.example.quanlysanpham3.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/get-product-response")
    public ResponseEntity<List<GetProductResponse>> getProductResponse() {
        List<GetProductResponse> listProduct = testService.getProductResponse();
        return new ResponseEntity<List<GetProductResponse>>(listProduct, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = testService.getProductById(id);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<List<GetDetailProductResponse>> getProductDetails() {
        List<GetDetailProductResponse> listProduct = testService.getDetailProoductResponse();
        return new ResponseEntity<List<GetDetailProductResponse>>(listProduct, HttpStatus.OK);
    }

    @PostMapping("/create-product-request")
    public ResponseEntity<Product> createProductRequest(@RequestBody CreateProductRequest request) {
        Product createProduct = testService.createProductRequest(request);
        return new ResponseEntity<Product>(createProduct, HttpStatus.CREATED);
    }
}
