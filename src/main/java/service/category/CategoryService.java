package service.category;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.category.ICategoryRepository;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.delete(id);
    }
}
