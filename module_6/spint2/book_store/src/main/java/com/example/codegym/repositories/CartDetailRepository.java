package com.example.codegym.repositories;

import com.example.codegym.models.dto.GetCartDetailDto;
import com.example.codegym.models.dto.GetProductDto;
import com.example.codegym.models.entity.CartDetail;
import com.example.codegym.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    List<CartDetail> findByCartId(Long id);
    @Query(value = "select c.amount, c.id as cart_id, cd.quantity, cd.id as cd_id, p.name, p.image_url,p.unit_price, p.id from cart c  inner join cart_detail cd on cd.cart_id=c.id inner join product p on p.id=cd.product_id where c.user_id =:id and cd.is_payed=0;", nativeQuery = true)
   List <GetCartDetailDto>getCartDetailByUserId(@Param("id") Long id);

    CartDetail getById(Long id);

}
