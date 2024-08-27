package com.example.quanlysanpham3.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindProductRequest {

    private String productName;

    private Double price;

    private Long brandId;

    private Long categoryId;

    private Long statusId;

    // biet nguoi dung dang o trang nao
    private Integer page;

    // biet nguoi dung muon xem bao nhieu phan tu tren 1 trang
    private Integer size;

}
