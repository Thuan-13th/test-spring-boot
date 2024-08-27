package com.example.quanlysanpham3.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListDto {

    private Long rowNum;

    private String productName;

    private String brandName;

    private String subCateName;

    private Double price;

    private String statusName;

    private Long id;

}
