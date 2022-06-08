package com.example.demo.repository;


import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "SELECT * FROM customer where customer_name like concat('%',:name,'%') and customer_address like concat('%',:address,'%')",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM customer where customer_name like concat('%',:name,'%') and customer_address like concat('%',:address,'%')) abc" )
    Page<Customer> findAll(@Param("name") String name, @Param("address") String address,Pageable pageable);

    Customer findCustomerById(int id);
}
