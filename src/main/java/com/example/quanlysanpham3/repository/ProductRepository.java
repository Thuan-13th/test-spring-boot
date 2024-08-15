package com.example.quanlysanpham3.repository;

import com.example.quanlysanpham3.entity.Product;
import com.example.quanlysanpham3.model.response.GetDetailProductResponse;
import com.example.quanlysanpham3.model.response.GetProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = """
    SELECT 
    p.id AS product_id,
    p.produce_name AS product_name,
    p.color,
    p.quantity,
    p.sell_price,
    p.origin_price,
    p.description,
    s.status_name,
    sub.subcate_name AS subcategory_name,
    c.cate_name AS category_name,
    GROUP_CONCAT(b.brand_name) AS brand_names
FROM 
    product p
LEFT JOIN 
    status s ON p.status_id = s.id
LEFT JOIN 
    sub_category sub ON p.subcate_id = sub.id
LEFT JOIN 
    category c ON sub.cate_id = c.id
LEFT JOIN 
    product_brand pb ON p.id = pb.product_id
LEFT JOIN 
    brand b ON pb.brand_id = b.id
GROUP BY 
    p.id, 
    p.produce_name, 
    p.color, 
    p.quantity, 
    p.sell_price, 
    p.origin_price, 
    p.description,      
    s.status_name, 
    sub.subcate_name, 
    c.cate_name;
""", nativeQuery = true)
    List<GetProductResponse> getProductResponse();


    @Query(value ="""
    SELECT 
    p.produce_name AS productName,
    p.color,
    p.quantity,
    p.sell_price,
    p.origin_price,
    b.brand_name AS brandName
    sub.subcate_name AS subcategory_name,
    s.status_name AS statusName
FROM 
    product p
INNER JOIN 
    status s ON p.status_id = s.id
INNER JOIN 
    sub_category sub ON p.subcate_id = sub.id
INNER JOIN 
    category c ON sub.cate_id = c.id
INNER JOIN 
    product_brand pb ON p.id = pb.product_id
INNER JOIN 
    brand b ON pb.brand_id = b.id
GROUP BY 
    p.id, 
    p.produce_name, 
    p.color, 
    p.quantity, 
    p.sell_price, 
    p.origin_price, 
    s.status_name, 
    sub.subcate_name, 
    c.cate_name;
""", nativeQuery = true)
    List<GetDetailProductResponse> getDetailProoductResponse();
}
