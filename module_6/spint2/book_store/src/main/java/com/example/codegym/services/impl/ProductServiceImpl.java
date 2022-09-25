package com.example.codegym.services.impl;

import com.example.codegym.common.converter.ProductConverter;
import com.example.codegym.common.exception.ResourceNotFoundException;
import com.example.codegym.models.dto.GetProductDto;
import com.example.codegym.models.dto.ProductDTO;
import com.example.codegym.models.entity.Product;
import com.example.codegym.models.entity.ProductCategory;
import com.example.codegym.repositories.ProductRepository;
import com.example.codegym.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductConverter productConverter;

//    @Override
//    public List<ProductDTO> getAll() {
//        List<Product> products = productRepository.findByActiveTrue();
//
//        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
//
//        for (Product product : products) {
//            productDTOs.add(productConverter.toDTO(product));
//        }
//
//        return productDTOs;
//    }

    @Override
    public GetProductDto getById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productConverter.toEntity(productDTO);

        product = productRepository.save(product);

        productDTO.setId(product.getId());

        return productDTO;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO, Long id) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));

        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setUnitPrice(productDTO.getUnitPrice());
        existingProduct.setUnitInStock(productDTO.getUnitInStock());
        existingProduct.setActive(productDTO.getActive());
        existingProduct.setImageUrl(productDTO.getImageUrl());
        existingProduct.setCategory(
                new ProductCategory(productDTO.getCategory().getId(), productDTO.getCategory().getCategoryName(), productDTO.getCategory().getDescription()));

        Product product = productRepository.save(existingProduct);

        productDTO.setId(product.getId());

        return productDTO;

    }

    @Override
    public void delete(Long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + id));
        existingProduct.setActive(false);
        productRepository.save(existingProduct);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Page<Product> getAllPaginate(Pageable pageable) {


        Page<Product> productsDtoPage = productRepository.findByActiveTrue(pageable);

        return productsDtoPage;
    }

    @Override
    public Page<Product> getByName(String name, Pageable pageable) {

        Page<Product> productsPage = productRepository.findByNameContainingAndActiveTrue(name, pageable);

        return productsPage;
    }

    @Override
    public Page<Product> getByCategoryId(Long id, Pageable pageable) {

        Page<Product> productsPage = productRepository.findByCategoryIdAndActiveTrue(id, pageable);

        return productsPage;
    }

    @Override
    public Page<Product> findByNameAndCategory(Long id, String name,Pageable pageable ) {


        Page<Product> productsPage = productRepository.findByCategoryIdAndNameContainingAndActiveTrue(id, name, pageable);



        return productsPage;
    }

//    @Override
//    public Page<Product> getNewProduct(Pageable pageable) {
//
//        Pageable paging = PageRequest.of(page, size, Sort.by("id").descending());
//
//        Page<Product> productsPage = productRepository.findByActiveTrue(paging);
//
//        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);
//
//        return productsDtoPage;
//
//    }
//
//    @Override
//    public Page<ProductDTO> getByPriceDesc(Integer page, Integer size) {
//
//        Pageable paging = PageRequest.of(page, size, Sort.by("unitPrice").descending());
//
//        Page<Product> productsPage = productRepository.findByActiveTrue(paging);
//
//        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);
//
//        return productsDtoPage;
//    }
//
//    @Override
//    public Page<ProductDTO> getByPriceAsc(Integer page, Integer size) {
//
//        Pageable paging = PageRequest.of(page, size, Sort.by("unitPrice").ascending());
//
//        Page<Product> productsPage = productRepository.findByActiveTrue(paging);
//
//        Page<ProductDTO> productsDtoPage = productConverter.toPageProductDto(productsPage);
//
//        return productsDtoPage;
//    }
//
//    @Override
//    public List<ProductDTO> getByCategoryid(Long id) {
//
//        List<Product> products = productRepository.findByCategoryIdAndActiveTrue(id);
//
//        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
//
//        for (Product product : products) {
//            productDTOs.add(productConverter.toDTO(product));
//        }
//
//        return productDTOs;
//
//    }

}
