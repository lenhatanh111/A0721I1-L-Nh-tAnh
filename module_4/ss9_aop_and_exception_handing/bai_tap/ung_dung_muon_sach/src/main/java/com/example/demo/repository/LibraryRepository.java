package com.example.demo.repository;

import com.example.demo.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
    @Query(value = "select l.id,l.name,count(*) as quantity from library l inner join book b on l.id=b.library_id where b.status=1 group by id", nativeQuery = true,
            countQuery = "select count(*) from (select l.id,l.name,count(*) as quantity from library l inner join book b on l.id=b.library_id  where b.status=1 group by id ) xyz")
    Page<Library> getAllLibrary(Pageable pageable);
}
