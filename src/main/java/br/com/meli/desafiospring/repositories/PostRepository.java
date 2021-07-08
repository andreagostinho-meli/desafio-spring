package br.com.meli.desafiospring.repositories;

import br.com.meli.desafiospring.entities.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private List<Post> posts = new ArrayList<>();

    public void add(Post post) {
        posts.add(post);
    }

    public Post findById(int id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }
}
