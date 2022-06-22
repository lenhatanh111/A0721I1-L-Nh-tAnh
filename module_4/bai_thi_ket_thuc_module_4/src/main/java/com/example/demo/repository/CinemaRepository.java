package com.example.demo.repository;

import com.example.demo.model.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Integer> {
    @Query(value = "SELECT * FROM cinema where sale like concat('%',:sale,'%') and start_date like concat('%',:startDate,'%') and end_date like concat('%',:endDate,'%')",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM cinema where sale like concat('%',:sale,'%') and start_date like concat('%',:startDate,'%') and end_date like concat('%',:endDate,'%')) abc" )
    Page<Cinema> findAll(@Param("sale") String sale, @Param("startDate") String startDate,@Param("endDate") String endDate, Pageable pageable);
    Cinema findById(int id);
}
