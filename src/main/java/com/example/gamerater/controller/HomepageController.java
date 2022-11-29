package com.example.gamerater.controller;

import com.example.gamerater.model.Post;
import com.example.gamerater.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomepageController {

    private PostService postService;

    // Inject dependency
    public HomepageController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String displayHomepage(Model model){
        // get all posts and send them to view
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "home";
    }
}
