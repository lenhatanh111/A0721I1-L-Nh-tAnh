package com.example.codegym.services;

import com.example.codegym.models.dto.GetProductDto;
import com.example.codegym.models.dto.ProductDTO;
import com.example.codegym.models.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
Product getProductById(Long id);

    Page<Product> getAllPaginate(Pageable pageable);

    Page<Product> getByName(String name,Pageable pageable );

    Page<Product> getByCategoryId(Long id,Pageable pageable);

//    List<Product> getByCategoryid(Long id);
//
//    Page<Product> getNewProduct(Pageable pageable);
//
//    Page<Product> getByPriceDesc(Pageable pageable);
//
//    Page<Product> getByPriceAsc(Pageable pageable);

    Page<Product> findByNameAndCategory(Long id, String name, Pageable pageable);

    GetProductDto getById(Long id);

    ProductDTO save(ProductDTO product);

    ProductDTO update(ProductDTO product, Long id);

    void delete(Long id);
}
