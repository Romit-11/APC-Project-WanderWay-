package com.wanderway.controllers;

import com.wanderway.models.Blog;
import com.wanderway.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        return "blogs";
    }

    @GetMapping("/new")
    public String showBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "add-blog";
    }

    @PostMapping
    public String addBlog(@ModelAttribute Blog blog) {
        blogRepository.save(blog);
        return "redirect:/blogs";
    }
}
