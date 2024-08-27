package com.example.quanlysanpham3.service.impl;

import com.example.quanlysanpham3.config.exception.NotFoundException;
import com.example.quanlysanpham3.config.exception.RestApiException;
import com.example.quanlysanpham3.dto.product.ProductDetailDto;
import com.example.quanlysanpham3.dto.product.ProductListDto;
import com.example.quanlysanpham3.entity.Brand;
import com.example.quanlysanpham3.entity.Product;
import com.example.quanlysanpham3.entity.ProductBrand;
import com.example.quanlysanpham3.entity.Status;
import com.example.quanlysanpham3.entity.SubCategory;
import com.example.quanlysanpham3.model.request.CreateProductRequest;
import com.example.quanlysanpham3.model.request.FindProductRequest;
import com.example.quanlysanpham3.model.request.UpdateProductRequest;
import com.example.quanlysanpham3.model.response.ProductResponse;
import com.example.quanlysanpham3.repository.BrandRepository;
import com.example.quanlysanpham3.repository.ProductBrandRepository;
import com.example.quanlysanpham3.repository.ProductRepository;
import com.example.quanlysanpham3.repository.StatusRepository;
import com.example.quanlysanpham3.repository.SubCategoryRepository;
import com.example.quanlysanpham3.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final BrandRepository brandRepository;

    private final ProductBrandRepository productBrandRepository;

    private final SubCategoryRepository subCategoryRepository;

    private final SubCategoryRepository subCategoryCategoryRepository;

    private final ModelMapper modelMapper;

    private final StatusRepository statusRepository;

    // get product
    @Override
    public Page<ProductListDto> getProductResponse(FindProductRequest req) {
        // phan trang
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
        Page<ProductResponse> pageResponse = productRepository.getProductResponse(pageable, req);

            Page<ProductListDto> pageDTO = pageResponse.map(productResponse -> modelMapper.map(productResponse, ProductListDto.class));
            return pageDTO;
    }

    @Override
    public Boolean create(@Valid CreateProductRequest request) {
        Optional<Brand> brandFind = brandRepository.findById(request.getBrandId());
        if(!brandFind.isPresent()) {

            throw new NotFoundException();

        }
        Optional<SubCategory> subCategoryFind = subCategoryRepository.findById(request.getSubCateId());
        if(!subCategoryFind.isPresent()) {

            throw new NotFoundException();

        }

        Double originPrice = request.getOriginPrice();
        Double sellPrice = request.getSellPrice();

        if(originPrice > sellPrice) {

            throw new RestApiException("Gia ban phai lon hon gia goc");

        }

        Product product = new Product();
        product.setProduceName(request.getProductName());
        product.setColor(request.getColor());
        product.setQuantity(request.getQuantity());
        product.setSellPrice(request.getSellPrice());
        product.setOriginPrice(request.getOriginPrice());
        product.setSubcateId(request.getSubCateId());

        Status statusConHang = statusRepository.findById(1L).get();

        product.setStatusId(statusConHang.getId());

        Product productSave = productRepository.save(product);

        ProductBrand productBrand = new ProductBrand();
        productBrand.setBrandId(request.getBrandId());
        productBrand.setProductId(productSave.getId());
        productBrandRepository.save(productBrand);

        return true;
    }

    // get detail
    @Override
    public ProductDetailDto getProductDetail(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if(!product.isPresent()) {
            throw new NotFoundException();
        }

        ProductDetailDto productDetailDto = new ProductDetailDto();
        productDetailDto.setProductName(product.get().getProduceName());
        productDetailDto.setColor(product.get().getColor());
        productDetailDto.setQuantity(product.get().getQuantity());
        productDetailDto.setSellPrice(product.get().getSellPrice());
        productDetailDto.setOriginPrice(product.get().getOriginPrice());

        ProductBrand productBrand = productBrandRepository.findByProductId(id);
        productDetailDto.setBrandId(productBrand.getBrandId());

        productDetailDto.setSubCateId(product.get().getSubcateId());
        productDetailDto.setStatusId(product.get().getStatusId());

        return productDetailDto;
    }

    @Override
    public Boolean updateProductRequest(UpdateProductRequest updateProductRequest) {
        Optional<Product> product = productRepository.findById(updateProductRequest.getId());

        if(!product.isPresent()) {
            throw new NotFoundException();
        }

        Product updateProduct = product.get();
        updateProduct.setProduceName(updateProductRequest.getProductName());
        updateProduct.setColor(updateProductRequest.getColor());
        updateProduct.setQuantity(updateProductRequest.getQuantity());
        updateProduct.setSellPrice(updateProductRequest.getSellPrice());
        updateProduct.setOriginPrice(updateProductRequest.getOriginPrice());
        updateProduct.setSubcateId(updateProductRequest.getSubCateId());
        updateProduct.setStatusId(updateProductRequest.getStatusId());

        productRepository.save(updateProduct);

        ProductBrand updateProductBrand = productBrandRepository.findByProductId(product.get().getId());
        updateProductBrand.setBrandId(updateProductRequest.getBrandId());

        productBrandRepository.save(updateProductBrand);

        return true;
    }

    @Override
    public String deleteProduct(Long id) {

        Optional<Product> product = productRepository.findById(id);

        if(!product.isPresent()) {
            throw new NotFoundException();
        }

        productBrandRepository.deleteById(product.get().getId());
        productRepository.deleteById(product.get().getStatusId());
        productRepository.deleteById(product.get().getSubcateId());
        productRepository.deleteById(id);

        return "deleteProduct susscess product";
    }


}
