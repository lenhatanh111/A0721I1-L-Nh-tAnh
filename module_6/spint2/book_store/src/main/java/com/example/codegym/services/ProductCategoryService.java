package com.example.codegym.services;

import com.example.codegym.models.dto.ProductCategoryDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDTO> getAll();

    ProductCategoryDTO getByName(String name);

    Page<ProductCategoryDTO> getAllPaginate(Integer page, Integer size);

    ProductCategoryDTO save(ProductCategoryDTO product);

    ProductCategoryDTO update(ProductCategoryDTO product, Long id);

    ProductCategoryDTO findByid(Long id);

    void delete(Long id);

}
