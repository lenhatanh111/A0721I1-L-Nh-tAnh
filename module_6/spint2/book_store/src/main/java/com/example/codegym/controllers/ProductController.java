package com.example.codegym.controllers;

import com.example.codegym.models.dto.GetProductDto;
import com.example.codegym.models.dto.ProductDTO;
import com.example.codegym.models.entity.Product;
import com.example.codegym.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @GetMapping
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public List<ProductDTO> getAllProducts() {
//        return productService.getAll();
//    }

    @GetMapping("/all")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Page<Product>> getAllProductsPaginate(@PageableDefault(size =12) Pageable pageable) {
        Page<Product> products = productService.getAllPaginate(pageable);
        return ResponseEntity.ok(products);

    }

//    @GetMapping("/new")
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Page<Product>> getNewProductsPaginate(@RequestParam("page") Integer page,
//                                                                   @RequestParam("size") Integer size) {
//        Page<ProductDTO> products = productService.getNewProduct(page, size);
//        return ResponseEntity.ok(products);
//
//    }

//    @GetMapping("/price-desc")
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Page<ProductDTO>> getProductsByPriceDesc(@RequestParam("page") Integer page,
//                                                                   @RequestParam("size") Integer size) {
//        Page<ProductDTO> products = productService.getByPriceDesc(page, size);
//        return ResponseEntity.ok(products);
//
//    }

//    @GetMapping("/price-asc")
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Page<ProductDTO>> getProductsByPriceAsc(@RequestParam("page") Integer page,
//                                                                  @RequestParam("size") Integer size) {
//        Page<ProductDTO> products = productService.getByPriceAsc(page, size);
//        return ResponseEntity.ok(products);
//    }

    @GetMapping("/search")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Page<Product>> getAllProductsPaginate1( @RequestParam("name") String name, @PageableDefault(size =12) @SortDefault("lastUpdated") Pageable pageable) {
        Page<Product> products = productService.getByName(name ,pageable);
        return ResponseEntity.ok(products);
    }

//    @GetMapping("/filter")
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Page<ProductDTO>> getAllProductsPaginate2(@RequestParam("page") Integer page,
//                                                                    @RequestParam("size") Integer size , @RequestParam("categoryId") Long id) {
//        Page<ProductDTO> products = productService.getByCategory(id , page, size);
//        return ResponseEntity.ok(products);
//    }
//
    @GetMapping("/detail/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<GetProductDto> getProductById(@PathVariable(value = "id") long id) {
        GetProductDto productDto =productService.getById(id);
        System.out.println(productDto);
        return ResponseEntity.ok(productService.getById(id));

    }
//

    @GetMapping("category/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Page<Product>> getProductByCategoryId(@PathVariable(value = "id") long id,@PageableDefault(size =12) Pageable pageable) {
        return ResponseEntity.ok(productService.getByCategoryId(id,pageable));
    }
//
//    @PostMapping
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO product) {
//        ProductDTO newProduct = productService.save(product);
//        return new ResponseEntity<ProductDTO>(newProduct, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO product, @PathVariable("id") long id) {
//        ProductDTO newProduct = productService.update(product, id);
//        return new ResponseEntity<ProductDTO>(newProduct, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
//        productService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/filter-category-name")
//    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Page<ProductDTO>> findByCatgoryAndName(@RequestParam("page") Integer page,
//                                                                 @RequestParam("size") Integer size , @RequestParam("name") String name, @RequestParam("categoryId") Long id) {
//        Page<ProductDTO> products = this.productService.findByNameAndCategory(id, name, page, size);
//        return ResponseEntity.ok(products);
//    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "for admin";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MOD')")
    public String mod() {
        return "for mod";
    }

}
