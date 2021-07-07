package br.com.meli.desafiospring.dto.user.getfollowers;

import br.com.meli.desafiospring.dto.user.UserDTO;

import java.util.List;

public class GetFollowersResponseDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followers;

    public GetFollowersResponseDTO(int userId, String userName, List<UserDTO> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }
}
