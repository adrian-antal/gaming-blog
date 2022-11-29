package com.example.gamerater.service;

import com.example.gamerater.model.Post;
import com.example.gamerater.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> getById(Long id){
        return postRepository.findById(id);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }
}
