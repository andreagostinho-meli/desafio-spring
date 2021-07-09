package br.com.meli.desafiospring.services;

import br.com.meli.desafiospring.dto.post.create.CreatePostRequestDTO;
import br.com.meli.desafiospring.dto.post.getpostsfromfollowedusers.GetPostsFromFollowedUsersResponseDTO;
import br.com.meli.desafiospring.dto.post.getpostsfromfollowedusers.PostFromFollowedUserDTO;
import br.com.meli.desafiospring.dto.post.getpostsfromfollowedusers.ProductFromPostDTO;
import br.com.meli.desafiospring.dto.product.ProductDTO;
import br.com.meli.desafiospring.dto.user.UserDTO;
import br.com.meli.desafiospring.entities.Post;
import br.com.meli.desafiospring.entities.Product;
import br.com.meli.desafiospring.exceptions.PostAlreadyExistsException;
import br.com.meli.desafiospring.exceptions.ProductAlreadyExistsException;
import br.com.meli.desafiospring.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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

    public List<PostFromFollowedUserDTO> getPostsFromFollowedUsers(List<UserDTO> usersFollowed) {
        List<Post> postsFromFollowedUsers = new ArrayList<>();
        List<PostFromFollowedUserDTO> filteredPosts = new ArrayList<>();

        usersFollowed.forEach(user ->
                postsFromFollowedUsers.addAll(postRepository.findUserPosts(user.getUserId()))
        );

        postsFromFollowedUsers.forEach(post -> {
            String[] splittedDate = post.getDate().split("-");

            String day = splittedDate[0];
            String month = splittedDate[1];
            String year = splittedDate[2];

            LocalDate startDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            LocalDate endDate = LocalDate.now();

            long weeks = ChronoUnit.WEEKS.between(startDate, endDate);

            if(weeks <= 2) {
                ProductFromPostDTO productFromPostDTO = new ProductFromPostDTO(
                        post.getProduct().getId(),
                        post.getProduct().getName(),
                        post.getProduct().getType(),
                        post.getProduct().getBrand(),
                        post.getProduct().getColor(),
                        post.getProduct().getNotes(),
                        post.getProduct().getCategoryId(),
                        post.getProduct().getPrice()
                );

                PostFromFollowedUserDTO postFromFollowedUserDTO = new PostFromFollowedUserDTO(
                        post.getId(),
                        post.getDate(),
                        productFromPostDTO
                );

                filteredPosts.add(postFromFollowedUserDTO);
            }
        });

        return filteredPosts;
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
