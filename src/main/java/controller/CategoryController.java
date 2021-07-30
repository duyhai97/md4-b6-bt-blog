package controller;


import model.Blog;
import model.Category;
import model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.blog.IBlogService;
import service.category.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@SessionAttributes("counter")
public class CategoryController {

    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @Autowired
    private ICategoryService categoryService;


//    @GetMapping("/list")
//    public ModelAndView showList(@ModelAttribute("counter") Counter counter){
//        ModelAndView modelAndView = new ModelAndView("/category/listCategory",
//                "categoryList", categoryService.findAll());
//        counter.increment();
//        return modelAndView;
//    }


    @GetMapping()
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findByID(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateBlog(@PathVariable Long id, @RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteBlog(@PathVariable Long id){
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }








}
