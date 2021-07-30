package service.blog;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import repository.blog.IBlogRepository;

import java.util.List;

public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository repository;


    @Override
    public List<Blog> findAll() {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(Blog customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }

    @Override
    public Blog findById1(Long id) {
        return repository.findById1(id);
    }

    @Override
    public List<Blog> findAllOrderByNameDesc() {
      return   repository.findAllOrderByNameDesc();
    }
}
