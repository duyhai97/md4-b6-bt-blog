package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView createNewBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect){
        blog.setId((long) (Math.random() * 10000));
        this.blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        modelAndView.addObject("customer", new Blog());

        modelAndView.addObject("success","Them moi thanh cong");
        return modelAndView;
    }
}
