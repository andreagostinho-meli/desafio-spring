package br.com.meli.desafiospring.controllers;

import br.com.meli.desafiospring.dto.user.UserDTO;
import br.com.meli.desafiospring.dto.user.create.CreateUserRequestDTO;
import br.com.meli.desafiospring.dto.user.getfollowers.GetFollowersResponseDTO;
import br.com.meli.desafiospring.dto.user.getfollowersquantity.GetUserFollowersQuantityResponseDTO;
import br.com.meli.desafiospring.dto.user.getfollowing.GetFollowingResponseDTO;
import br.com.meli.desafiospring.helpers.UserNameComparator;
import br.com.meli.desafiospring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    private UserNameComparator userNameComparator = new UserNameComparator();

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDTO create(@Valid @RequestBody CreateUserRequestDTO createUserRequestDTO) {
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

    @GetMapping("/users/{userId}/followers/list")
    @ResponseBody
    public GetFollowersResponseDTO getUserFollowers(@PathVariable int userId, @RequestParam String order) {
        if(order.isBlank()) order = "name_asc";

        GetFollowersResponseDTO response = userService.getUserFollowers(userId);

        if(order.equals("name_asc"))
            Collections.sort(response.getFollowers(), userNameComparator);
        else
            Collections.sort(response.getFollowers(), Collections.reverseOrder(userNameComparator));

        return response;
    }

    @GetMapping("/users/{userId}/followed/list")
    @ResponseBody
    public GetFollowingResponseDTO getUserFollowing(@PathVariable int userId, @RequestParam String order) {
        if(order.isBlank()) order = "name_asc";

        GetFollowingResponseDTO response = userService.getUserFollowing(userId);

        if(order.equals("name_asc"))
            Collections.sort(response.getFollowed(), userNameComparator);
        else
            Collections.sort(response.getFollowed(), Collections.reverseOrder(userNameComparator));

        return response;
    }
}
