package com.example.quanlysanpham3.model.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteProductReqest {

    private String productName;

    private String color;

    private Long quantity;

    private Double sellPrice;

    private Double originPrice;

    private Long brandId;

    private Long subCateId;
}
