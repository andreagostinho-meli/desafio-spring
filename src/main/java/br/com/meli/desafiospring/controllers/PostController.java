package br.com.meli.desafiospring.controllers;

import br.com.meli.desafiospring.dto.post.create.CreatePostRequestDTO;
import br.com.meli.desafiospring.dto.post.getpostsfromfollowedusers.GetPostsFromFollowedUsersResponseDTO;
import br.com.meli.desafiospring.dto.post.getpostsfromfollowedusers.PostFromFollowedUserDTO;
import br.com.meli.desafiospring.dto.user.UserDTO;
import br.com.meli.desafiospring.helpers.PostDateComparator;
import br.com.meli.desafiospring.services.PostService;
import br.com.meli.desafiospring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

     PostDateComparator postDateComparator = new PostDateComparator();

    @PostMapping("/products/newpost")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreatePostRequestDTO createPostRequestDTO) {
        postService.create(createPostRequestDTO);
    }

    @GetMapping("/products/followed/{userId}/list")
    @ResponseBody
    public GetPostsFromFollowedUsersResponseDTO getPostsFromFollowedUsers(@PathVariable int userId, @RequestParam String order) {
        if(order.isBlank()) order = "date_desc";

        List<UserDTO> usersFollowed = userService.getUserFollowing(userId).getFollowed();
        List<PostFromFollowedUserDTO> posts = postService.getPostsFromFollowedUsers(usersFollowed);

        if(order.equals("date_asc"))
            Collections.sort(posts, postDateComparator);
        else
            Collections.sort(posts, Collections.reverseOrder(postDateComparator));

        return new GetPostsFromFollowedUsersResponseDTO(userId, posts);
    }

}
