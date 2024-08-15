package com.example.quanlysanpham3.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    private String productName;
    private String color;
    private Long quantity;
    private Double sellPrice;
    private Double originPrice;
    private String brandName;
    private String subCateName;
}
