package com.example.demo.repository;

import com.example.demo.dto.SelectAllCustomerDto;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectAllCustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c.id,c.customer_name,c.customer_birthday,c.customer_email,c.customer_gender," +
            "c.customer_id_card," +
            "c.customer_phone,c.customer_address,ct.customer_type_name,ctr.contract_deposit,\n" +
            "ctr.contract_total_money,ctr.contract_start_date,ctr.contract_end_date,cd.quantity,ats.attach_service_name from customer c inner join customer_type ct on c.customer_type_id=ct.id\n" +
            "inner join contract ctr on c.id=ctr.customer_id inner join contract_detail cd on cd.contract_id=ctr.id inner join attach_service ats on ats.id=cd.attach_service_id",
            nativeQuery = true,
            countQuery = "select count(*) from ( select c.id,c.customer_name,c.customer_birthday,c.customer_email,c.customer_gender,c.customer_id_card,c.customer_phone,c.customer_address,ct.customer_type_name,ctr.contract_deposit,\n" +
                    "ctr.contract_total_money,ctr.contract_start_date,ctr.contract_end_date,cd.quantity,ats.attach_service_name from customer c inner join customer_type ct on c.customer_type_id=ct.id\n" +
                    "inner join contract ctr on c.id=ctr.customer_id inner join contract_detail cd on cd.contract_id=ctr.id inner join attach_service ats on ats.id=cd.attach_service_id) abc" )
    Page<SelectAllCustomerDto> getAllCustomerIsUsingService(Pageable pageable);
}
