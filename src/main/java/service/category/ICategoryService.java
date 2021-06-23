package service.category;

import model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {

    List<Category> findAll();

    void save(Category category);

    Category findById(Long id);

    void remove(Long id);

}
