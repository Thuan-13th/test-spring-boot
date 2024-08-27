package com.example.quanlysanpham3.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailDto {

    private String productName;

    private String color;

    private Long quantity;

    private Double sellPrice;

    private Double originPrice;

    private Long brandId;

    private Long subCateId;

    private Long statusId;

}
