package br.com.meli.desafiospring.controllers;

import br.com.meli.desafiospring.dto.post.create.CreatePostRequestDTO;
import br.com.meli.desafiospring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/products/newpost")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreatePostRequestDTO createPostRequestDTO) {
        postService.create(createPostRequestDTO);
    }
}
