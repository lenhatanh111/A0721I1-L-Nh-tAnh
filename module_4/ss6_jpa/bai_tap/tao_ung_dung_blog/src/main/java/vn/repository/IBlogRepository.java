package vn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.entity.Blog;

@Repository
public interface IBlogRepository extends CrudRepository<Blog,Integer> {
}
