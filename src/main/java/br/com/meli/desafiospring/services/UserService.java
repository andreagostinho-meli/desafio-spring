package br.com.meli.desafiospring.services;

import br.com.meli.desafiospring.dto.user.UserDTO;
import br.com.meli.desafiospring.dto.user.create.CreateUserRequestDTO;
import br.com.meli.desafiospring.dto.user.create.CreateUserResponseDTO;
import br.com.meli.desafiospring.dto.user.getfollowers.GetFollowersResponseDTO;
import br.com.meli.desafiospring.dto.user.getfollowersquantity.GetUserFollowersQuantityResponseDTO;
import br.com.meli.desafiospring.entities.User;
import br.com.meli.desafiospring.exceptions.FollowerNotFoundException;
import br.com.meli.desafiospring.exceptions.SameUserFollowException;
import br.com.meli.desafiospring.exceptions.UserIsAlreadyFollowerException;
import br.com.meli.desafiospring.exceptions.UserNotFoundException;
import br.com.meli.desafiospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private int id = 1;

    public CreateUserResponseDTO create(CreateUserRequestDTO createUserRequestDTO) {
        User user = new User(id, createUserRequestDTO.getName(), new ArrayList<>(), new ArrayList<>());
        id++;

        userRepository.add(user);

        return new CreateUserResponseDTO(user.getId(), user.getName());
    }

    public void followUser(int userId, int userIdToFollow) {
        checkIfUserIdsAreEqual(userId, userIdToFollow);

        User user = userRepository.findById(userId);
        checkIfUserExists(user);

        User userToFollow = userRepository.findById(userIdToFollow);
        checkIfUserExists(userToFollow);

        if(userToFollow.getFollowers().contains(user)) throw new UserIsAlreadyFollowerException();

        userRepository.addFollower(user, userToFollow);
    }

    public void unfollowUser(int userId, int userIdToUnfollow) {
        checkIfUserIdsAreEqual(userId, userIdToUnfollow);

        User user = userRepository.findById(userId);
        checkIfUserExists(user);

        User userToUnfollow = userRepository.findById(userIdToUnfollow);
        checkIfUserExists(userToUnfollow);

        if(!userToUnfollow.getFollowers().contains(user)) throw new FollowerNotFoundException();

        userRepository.removeFollower(user, userToUnfollow);
    }

    public GetUserFollowersQuantityResponseDTO countUserFollowers(int id) {
        User user = userRepository.findById(id);
        checkIfUserExists(user);

        return new GetUserFollowersQuantityResponseDTO(id, user.getName(), user.getFollowers().size());
    }

    public GetFollowersResponseDTO getUserFollowers(int id) {
        User user = userRepository.findById(id);
        checkIfUserExists(user);

        List<UserDTO> followers = user.getFollowers().stream()
                                    .map(follower -> new UserDTO(follower.getId(), follower.getName()))
                                    .collect(Collectors.toList());

        return new GetFollowersResponseDTO(user.getId(), user.getName(), followers);
    }

    private void checkIfUserExists(User user) {
        if(user == null) throw new UserNotFoundException();
    }

    private void checkIfUserIdsAreEqual(int id1, int id2) {
        if(id1 == id2) throw new SameUserFollowException();
    }

}
