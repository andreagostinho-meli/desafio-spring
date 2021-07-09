package br.com.meli.desafiospring.repositories;

import br.com.meli.desafiospring.entities.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository {
    private List<Post> posts = new ArrayList<>();

    public void add(Post post) {
        posts.add(post);
    }

    public Post findById(int id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }

    public List<Post> findUserPosts(int userId) {
        return posts.stream().filter(post -> post.getUserId() == userId).collect(Collectors.toList());
    }
}
