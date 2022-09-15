package com.example.codegym.services.impl;

import com.example.codegym.common.converter.ProductCategoryConverter;
import com.example.codegym.common.exception.ResourceNotFoundException;
import com.example.codegym.models.dto.ProductCategoryDTO;
import com.example.codegym.models.entity.ProductCategory;
import com.example.codegym.repositories.ProductCategoryRepository;
import com.example.codegym.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductCategoryConverter productCategoryConverter;

//    @Override
//    public List<ProductCategoryDTO> getAll() {
//        List<ProductCategory> categories = productCategoryRepository.findByActiveTrue();
//        List<ProductCategoryDTO> categoryDTOs = new ArrayList<ProductCategoryDTO>();
//        for (ProductCategory category : categories) {
//            categoryDTOs.add(productCategoryConverter.toDTO(category));
//        }
//
//        return categoryDTOs;
//
//    }

    @Override
    public List<ProductCategory> getAllPaginate() {

        List<ProductCategory> productsPage = productCategoryRepository.findAllByActiveTrue();

        return productsPage;
    }

//    @Override
//    public ProductCategoryDTO save(ProductCategoryDTO productDTO) {
//        ProductCategory product = productCategoryConverter.toEntity(productDTO);
//        product = productCategoryRepository.save(product);
//        productDTO.setId(product.getId());
//
//        return productDTO;
//    }
//
//    @Override
//    public ProductCategoryDTO update(ProductCategoryDTO product, Long id) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//        ProductCategory existingProduct = productCategoryRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
//
//        existingProduct.setActive(false);
//        productCategoryRepository.save(existingProduct);
//    }
//
//    @Override
//    public ProductCategoryDTO findByid(Long id) {
//        ProductCategory existingProduct = productCategoryRepository.findByIdAndActiveTrue(id);
//        return productCategoryConverter.toDTO(existingProduct);
//    }
//
//    @Override
//    public ProductCategoryDTO getByName(String name) {
//        ProductCategory existingProduct = productCategoryRepository.findByCategoryNameAndActiveTrue(name);
//        return productCategoryConverter.toDTO(existingProduct);
//
//    }
}
