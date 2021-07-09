package br.com.meli.desafiospring.dto.post.getpostsfromfollowedusers;

import java.util.List;

public class GetPostsFromFollowedUsersResponseDTO {
    private int userId;
    private List<PostFromFollowedUserDTO> posts;

    public GetPostsFromFollowedUsersResponseDTO(int userId, List<PostFromFollowedUserDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PostFromFollowedUserDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostFromFollowedUserDTO> posts) {
        this.posts = posts;
    }
}
