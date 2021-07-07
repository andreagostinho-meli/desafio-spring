package br.com.meli.desafiospring.repositories;

import br.com.meli.desafiospring.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public void addFollower(User follower, User userToFollow) {
        List<User> currentFollowers = userToFollow.getFollowers();
        currentFollowers.add(follower);
        userToFollow.setFollowers(currentFollowers);

        List<User> currentFollowing = follower.getFollowing();
        currentFollowing.add(userToFollow);
        follower.setFollowing(currentFollowing);
    }

    public void removeFollower(User follower, User userToUnfollow) {
        List<User> currentFollowers = userToUnfollow.getFollowers();
        currentFollowers.remove(follower);
        userToUnfollow.setFollowers(currentFollowers);

        List<User> currentFollowing = follower.getFollowing();
        currentFollowing.remove(userToUnfollow);
        follower.setFollowing(currentFollowing);
    }

    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

}
