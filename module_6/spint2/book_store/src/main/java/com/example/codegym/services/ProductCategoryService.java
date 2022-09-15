package com.example.codegym.services;

import com.example.codegym.models.dto.ProductCategoryDTO;
import com.example.codegym.models.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCategoryService {
//    List<ProductCategoryDTO> getAll();
//
//    ProductCategoryDTO getByName(String name);

    List<ProductCategory> getAllPaginate();

//    ProductCategoryDTO save(ProductCategoryDTO product);
//
//    ProductCategoryDTO update(ProductCategoryDTO product, Long id);
//
//    ProductCategoryDTO findByid(Long id);
//
//    void delete(Long id);

}
