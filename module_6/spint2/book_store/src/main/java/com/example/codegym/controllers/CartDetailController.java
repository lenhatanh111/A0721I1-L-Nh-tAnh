package com.example.codegym.controllers;

import com.example.codegym.models.dto.CartDetailDTO;
import com.example.codegym.models.dto.GetCartDetailDto;
import com.example.codegym.models.dto.TotalDto;
import com.example.codegym.models.entity.Cart;
import com.example.codegym.models.entity.CartDetail;
import com.example.codegym.services.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cart-detail")
public class CartDetailController {
    @Autowired
    CartDetailService cartDetailService;

    @PostMapping
    public ResponseEntity<CartDetailDTO> save(@RequestBody CartDetailDTO cartDetail) {

        CartDetailDTO cartDetailDTO = cartDetailService.save(cartDetail);

        return new ResponseEntity<CartDetailDTO>(cartDetailDTO, HttpStatus.CREATED);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<List<CartDetailDTO>> getByCartId(@PathVariable("id") Long id) {

        List<CartDetailDTO> cartDetailDTOs = cartDetailService.getByCartId(id);

        return ResponseEntity.ok(cartDetailDTOs);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDetailDTO> getById(@PathVariable("id") Long id) {

        CartDetailDTO cartDetailDTO = cartDetailService.getById(id);

        return ResponseEntity.ok(cartDetailDTO);

    }

    @PutMapping
    public ResponseEntity<CartDetailDTO> update(@RequestBody CartDetailDTO cartDetail) {
        CartDetailDTO cartDetailDTO = cartDetailService.update(cartDetail);
        return ResponseEntity.ok(cartDetailDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartDetailDTO> delete (@PathVariable("id") long id) {
        cartDetailService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("addToCart/{userId}/{productId}")
    public ResponseEntity<List<Cart>> addToCart (@PathVariable("userId") long userId,@PathVariable("productId") long productId) {
        List<Cart> carts = cartDetailService.addToCartDetail(userId,productId);
        return ResponseEntity.ok(carts);
    }
    @GetMapping("setQuantity/{userId}/{productId}/{quantity}")
    public ResponseEntity<List<Cart>> setQuantityOfProduct (@PathVariable("userId") long userId,@PathVariable("productId") long productId,
                                                            @PathVariable("quantity")int quantity) {
        List<Cart> carts = cartDetailService.setQuantityOfProduct(userId,productId,quantity);
        return ResponseEntity.ok(carts);
    }
    @GetMapping("/getCartDetail/{id}")
    public ResponseEntity<List<GetCartDetailDto>> getCartDetail (@PathVariable("id") long id) {
        List<GetCartDetailDto> cartDetailDtos = cartDetailService.getCartDetailByUserId(id);
        return ResponseEntity.ok(cartDetailDtos);
    }
@GetMapping("/getTotal/{id}")
    public ResponseEntity<TotalDto> getTotal(@PathVariable("id") long id){
        return ResponseEntity.ok(cartDetailService.getTotal(id));
}
@GetMapping("deleteProduct/{id}")
public ResponseEntity<CartDetail> deleteProduct(@PathVariable("id") long id){
    return ResponseEntity.ok(cartDetailService.deleteProductCartDetailId(id));
}
}
