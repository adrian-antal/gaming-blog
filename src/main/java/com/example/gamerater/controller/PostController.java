package com.example.gamerater.controller;

import com.example.gamerater.model.Post;
import com.example.gamerater.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PostController {

    private PostService postService;

    // Inject dependency
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model model){
        // find post by ID
        Optional<Post> findPostById = postService.getById(id);
        // if post was found, store it in an object and send to view
        if(findPostById.isPresent()){
            Post post = findPostById.get();
            model.addAttribute(post);
            return "post";
        } else {
            // otherwise return error page
            return "error";
        }
    }

}
