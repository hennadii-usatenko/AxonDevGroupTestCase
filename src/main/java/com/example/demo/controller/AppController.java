package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AppController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    private User getAuthenticationUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        if(user == null)
            return new User();
        else
            return user;
    }

    @GetMapping("/local/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("posts", postService.getAllPosts());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/admin/home/myblog")
    public ModelAndView myBlog(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("posts", postService.getByUserId(getAuthenticationUser().getId()));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/admin/create/post")
    public ModelAndView createPost(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("post", new Post());
        modelAndView.setViewName("create-post");
        return modelAndView;
    }

    @PostMapping("/admin/create/post")
    public String createNewPost(@ModelAttribute("post") @Valid Post post){
        post.setUserId(getAuthenticationUser().getId());
        postService.savePost(post);
        return "redirect:/local/post/" + post.getId();
    }

    @GetMapping("/local/post/{postId}")
    public ModelAndView blogPost(@PathVariable Integer postId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("post", postService.getById(postId));
        modelAndView.addObject("user", getAuthenticationUser());
        modelAndView.setViewName("blog-post");
        return modelAndView;
    }

    @GetMapping("/admin/update/post/{postId}")
    public ModelAndView updatePost(@PathVariable Integer postId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("post", postService.getById(postId));
        modelAndView.setViewName("update-post");
        return modelAndView;
    }

    @PostMapping("/admin/update/post")
    public String modifyPost(@ModelAttribute("post") @Valid Post post){
        postService.savePost(post);
        return "redirect:/local/post/" + post.getId();
    }

    @GetMapping("/admin/delete/post/{postId}")
    public String deletePost(@PathVariable Integer postId){
        postService.deletePostById(postId);
        return "redirect:/local/home/";
    }

}
