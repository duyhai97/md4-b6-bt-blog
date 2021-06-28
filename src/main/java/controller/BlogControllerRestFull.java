package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.blog.IBlogService;
import service.category.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/blogRestFull")
public class BlogControllerRestFull {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/list")
    public ModelAndView showListBlog(){
        List<Blog> blogList = this.blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/listBlog");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping()
    public ResponseEntity<List<Blog>> listBog(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Long id){
        return  new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id){
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
