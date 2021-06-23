
package service.blog;

import model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}