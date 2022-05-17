package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.Library;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value="select * from book b inner join library l on b.library_id=l.id where id=:id and b.status=1",nativeQuery = true,
            countQuery = "select count(*) from (select * from book b inner join library l on b.library_id=l.id where id=:id and b.status=1) xyz")
    Page<Book> getAllBook(@Param("id")Integer id, Pageable pageable);
//    @Query(value="insert into book(author,`status`,title) value(:author,:status,:title)",nativeQuery = true)
//    void save(@Param("author")String author,@Param("status")Boolean status,@Param("title")String title);
//   @Query(value="update book set status=0 where bookId= :id",nativeQuery = true)
//    void borrowBook(@Param("id")int id);
//    @Query(value="call library_manager.update_library_id(:title)",nativeQuery = true)
//    void updateLibraryId(@Param("title")String title);
}
