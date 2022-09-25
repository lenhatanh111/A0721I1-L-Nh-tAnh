package com.example.codegym.repositories;
import com.example.codegym.models.dto.GetProductDto;
import com.example.codegym.models.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long > {

    List<Product> findByActiveTrue();

    List<Product> findByNameAndActiveTrue(String name);

    Product findByIdAndActiveTrue(Long id);

    Page<Product> findByActiveTrue(Pageable pageable);

    Page<Product> findByNameContainingAndActiveTrue(String name, Pageable pageable);

    List<Product> findByCategoryIdAndActiveTrue(Long id);

    Page<Product> findByCategoryIdAndActiveTrue(Long id, Pageable pageable);

    Page<Product> findByCategoryIdAndNameContainingAndActiveTrue(Long id, String name, Pageable pageable);
    @Query(value = "select product.id, product.active,product.date_created,product.description,product.image_url,product.last_update,product.name,product.unit_in_stock,product.unit_price,a.name as author_name,a.id as author_id,pub.id as publisher_id,pub.name as publisher_name from product " +
            "inner join author a on product.author_id=a.id inner join publisher pub on pub.id=product.publisher_id where product.id=:id", nativeQuery = true)
    GetProductDto getProductById(@Param("id") Long id);
//
Product findProductById(Long id);
}
