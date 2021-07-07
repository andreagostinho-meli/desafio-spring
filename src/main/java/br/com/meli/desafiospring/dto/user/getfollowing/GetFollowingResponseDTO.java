package br.com.meli.desafiospring.dto.user.getfollowing;

import br.com.meli.desafiospring.dto.user.UserDTO;

import java.util.List;

public class GetFollowingResponseDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followed;

    public GetFollowingResponseDTO(int userId, String userName, List<UserDTO> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
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

    public List<UserDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UserDTO> followed) {
        this.followed = followed;
    }
}
