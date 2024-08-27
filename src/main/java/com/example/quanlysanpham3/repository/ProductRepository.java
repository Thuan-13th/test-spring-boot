package com.example.quanlysanpham3.repository;

import com.example.quanlysanpham3.dto.product.ProductDetailDto;
import com.example.quanlysanpham3.entity.Product;
import com.example.quanlysanpham3.model.request.FindProductRequest;
import com.example.quanlysanpham3.model.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            SELECT ROW_NUMBER () OVER (ORDER BY p.id DESC) AS rowNum,
            p.id, p.produce_name AS productName,
            b.brand_name AS brandName, p.origin_price AS price, st.status_name AS statusName,
            s.subcate_name AS subCateName FROM product p

            LEFT JOIN product_brand pb ON pb.product_id = p.id
            LEFT JOIN brand b ON b.id = pb.brand_id
            LEFT JOIN sub_category s ON p.subcate_id = s.id
            LEFT JOIN category c ON s.cate_id = c.id
            LEFT JOIN status st ON p.status_id = st.id
            
            WHERE (:#{#req.productName} IS NULL OR :#{#req.productName} LIKE '' OR p.produce_name LIKE %:#{#req.productName}%)
            AND (:#{#req.price} IS NULL OR :#{#req.price} LIKE '' OR p.origin_price = :#{#req.price})
            AND (:#{#req.brandId} IS NULL OR :#{#req.brandId} LIKE '' OR b.id = :#{#req.brandId})
            AND (:#{#req.categoryId} IS NULL OR :#{#req.categoryId} LIKE '' OR c.id = :#{#req.categoryId})
            AND (:#{#req.statusId} IS NULL OR :#{#req.statusId} LIKE '' OR st.id = :#{#req.statusId})
            ORDER BY p.id DESC
                """, countQuery = """
            SELECT COUNT(p.id) FROM product p
            LEFT JOIN product_brand pb ON pb.product_id = p.id
            LEFT JOIN brand b ON b.id = pb.brand_id
            LEFT JOIN sub_category s ON p.subcate_id = s.id
            LEFT JOIN category c ON s.cate_id = c.id
            LEFT JOIN status st ON p.status_id = st.id
            WHERE (:#{#req.productName} IS NULL OR :#{#req.productName} LIKE '' OR p.produce_name LIKE %:#{#req.productName}%)
            AND (:#{#req.price} IS NULL OR :#{#req.price} LIKE '' OR p.origin_price = :#{#req.price})
            AND (:#{#req.brandId} IS NULL OR :#{#req.brandId} LIKE '' OR b.id = :#{#req.brandId})
            AND (:#{#req.categoryId} IS NULL OR :#{#req.categoryId} LIKE '' OR c.id = :#{#req.categoryId})
            AND (:#{#req.statusId} IS NULL OR :#{#req.statusId} LIKE '' OR st.id = :#{#req.statusId})
            ORDER BY p.id DESC  
            """, nativeQuery = true)
    // phân trang
    Page<ProductResponse> getProductResponse(Pageable pageable, @Param("req") FindProductRequest req);

}
