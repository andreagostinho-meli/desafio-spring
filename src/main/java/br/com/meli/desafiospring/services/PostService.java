package br.com.meli.desafiospring.services;

import br.com.meli.desafiospring.dto.post.create.CreatePostRequestDTO;
import br.com.meli.desafiospring.dto.product.ProductDTO;
import br.com.meli.desafiospring.entities.Post;
import br.com.meli.desafiospring.entities.Product;
import br.com.meli.desafiospring.exceptions.PostAlreadyExistsException;
import br.com.meli.desafiospring.exceptions.ProductAlreadyExistsException;
import br.com.meli.desafiospring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public void create(CreatePostRequestDTO createPostRequestDTO) {
        checkIfUserExists(createPostRequestDTO.getUserId());
        checkIfPostAlreadyExists(createPostRequestDTO.getId_post());
        checkIfProductAlreadyExists(createPostRequestDTO.getDetail().getProduct_id());

        ProductDTO product = productService.create(createPostRequestDTO.getDetail());

        Post post = new Post(
                createPostRequestDTO.getId_post(),
                createPostRequestDTO.getUserId(),
                createPostRequestDTO.getDate(),
                new Product(
                        product.getProduct_id(),
                        product.getProductName(),
                        product.getType(),
                        product.getBrand(),
                        product.getColor(),
                        product.getNotes(),
                        product.getCategory(),
                        product.getPrice()
                )
        );

        postRepository.add(post);
    }

    private void checkIfUserExists(int id) {
        userService.findById(id);
    }

    private void checkIfPostAlreadyExists(int id) {
        Post post = postRepository.findById(id);
        if(post != null) throw new PostAlreadyExistsException();
    }

    private void checkIfProductAlreadyExists(int id) {
        Product product = productService.findById(id);
        if(product != null) throw new ProductAlreadyExistsException();
    }
}
