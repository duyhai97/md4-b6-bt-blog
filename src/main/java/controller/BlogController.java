package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IBlogService;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView showListBlog(){
        List<Blog> blogList = this.blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createNewBlog( Blog blog, RedirectAttributes redirect){
        this.blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        redirect.addFlashAttribute("success","Them moi thanh cong");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editBlog(Blog blog, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        this.blogService.save(blog);
        redirect.addFlashAttribute("success","sua thanh cong");
        return modelAndView;
    }
    
    @GetMapping("/{id}/delete")
    public ModelAndView showFormDelete(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }
    
    @PostMapping("/delete")
    public ModelAndView deleteBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        this.blogService.remove(blog.getId());
        redirect.addFlashAttribute("success","Xoa thanh cong");
        return modelAndView;
    }
    
    @GetMapping("/{id}/view")
    public ModelAndView viewBlog(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }
    
}
