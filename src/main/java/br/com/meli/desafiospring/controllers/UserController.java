package br.com.meli.desafiospring.controllers;

import br.com.meli.desafiospring.dto.user.create.CreateUserRequestDTO;
import br.com.meli.desafiospring.dto.user.create.CreateUserResponseDTO;
import br.com.meli.desafiospring.dto.user.getfollowersquantity.GetUserFollowersQuantityResponseDTO;
import br.com.meli.desafiospring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CreateUserResponseDTO create(@Valid @RequestBody CreateUserRequestDTO createUserRequestDTO) {
        return userService.create(createUserRequestDTO);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public void followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        userService.unfollowUser(userId, userIdToUnfollow);
    }

    @GetMapping("/users/{userId}/followers/count")
    @ResponseBody
    public GetUserFollowersQuantityResponseDTO getUserFollowersQuantity(@PathVariable int userId) {
        return userService.countUserFollowers(userId);
    }
}
