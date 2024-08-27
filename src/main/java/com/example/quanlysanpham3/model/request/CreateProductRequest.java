package com.example.quanlysanpham3.model.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank (message = "Khong duoc de trong")
    private String productName;

    @NotBlank (message = "Khong duoc de trong")
    private String color;

    @NotNull (message = "Khong duoc de trong")
    private Long quantity;

    @DecimalMin(value = "1.0", message = "The price must be at least 1.0")
    @DecimalMax(value = "1000000.0", message = "The price must be less than or equal to 1000000.0")
    private Double sellPrice;

    @DecimalMin(value = "1.0", message = "The price must be at least 1.0")
    @DecimalMax(value = "1000000.0", message = "The price must be less than or equal to 1000000.0")
    private Double originPrice;

    @NotNull (message = "Khong duoc de trong")
    private Long brandId;

    private Long subCateId;
}
