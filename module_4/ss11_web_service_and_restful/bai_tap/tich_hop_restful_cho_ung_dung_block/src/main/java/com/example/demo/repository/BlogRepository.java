package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "SELECT * FROM blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%')  ",
            nativeQuery = true,
            countQuery = "select count(*) from ( SELECT * FROM blog where author like concat('%',:author,'%')  and category_id like concat('%',:category,'%') ) abc ")
    Page<Blog> findAll(@Param("author") String author, @Param("category") String category, Pageable pageable);
    @Query(value="select * from blog order by release_date ",nativeQuery = true,
            countQuery = "select count(*) from (select * from blog order by release_date ) xyz")
    Page<Blog> sortByReleaseDate(Pageable pageable);




}
