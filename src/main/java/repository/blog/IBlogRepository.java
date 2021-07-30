package repository.blog;

import model.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends CrudRepository<Blog, Long> {

    @Query("SELECT e FROM Blog e WHERE e.id = :id")
    Blog findById1(@Param("id") Long id);

    @Query(value = "SELECT e.* FROM Blog e ORDER BY e.name Asc ", nativeQuery = true)
    List<Blog> findAllOrderByNameDesc();

}
