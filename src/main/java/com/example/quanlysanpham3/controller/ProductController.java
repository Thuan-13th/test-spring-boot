package com.example.quanlysanpham3.controller;
import com.example.quanlysanpham3.dto.product.ProductDetailDto;
import com.example.quanlysanpham3.dto.product.ProductListDto;
import com.example.quanlysanpham3.model.request.CreateProductRequest;
import com.example.quanlysanpham3.model.request.FindProductRequest;
import com.example.quanlysanpham3.model.request.UpdateProductRequest;
import com.example.quanlysanpham3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<Page<ProductListDto>> searchProduct(FindProductRequest request) {
        return ResponseEntity.ok().body(productService.getProductResponse(request));
    }

    @GetMapping("/detail")
    public ResponseEntity<ProductDetailDto> detailProduct(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(productService.getProductDetail(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createProduct(@RequestBody CreateProductRequest request) {
        return ResponseEntity.ok().body(productService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateProduct(@RequestBody UpdateProductRequest request) {
        return ResponseEntity.ok().body(productService.updateProductRequest(request));
    }

    @DeleteMapping("delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

}
