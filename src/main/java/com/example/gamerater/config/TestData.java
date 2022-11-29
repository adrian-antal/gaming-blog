package com.example.gamerater.config;

import com.example.gamerater.model.Post;
import com.example.gamerater.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAllPosts();

        // create dummy posts for testing
        if(posts.size() == 0){
            Post post1 = new Post();
            post1.setTitle("Mafia Definitive Edition");
            post1.setDescription("Mafia: Definitive Edition is a 2020 action-adventure game developed by Hangar 13 and published by 2K Games. It is a remake of the 2002 video game Mafia, and the fourth main installment in the Mafia series.");
            post1.setImage("https://s2.gaming-cdn.com/images/products/6970/orig-fallback-v1/mafia-definitive-edition-definitive-edition-pc-game-steam-europe-cover.jpg?v=1651584193");

            Post post2 = new Post();
            post2.setTitle("Far Cry 6");
            post2.setDescription("Far Cry 6 is a 2021 action-adventure first-person shooter game developed by Ubisoft Toronto and published by Ubisoft. It is the sixth main installment in the Far Cry series and the successor to 2018's Far Cry 5.");
            post2.setImage("https://www.digiseller.ru/preview/657208/p1_3224038_7a6899b8.jpeg");

            postService.savePost(post1);
            postService.savePost(post2);
        }
    }
}
