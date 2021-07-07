package br.com.meli.desafiospring.dto.user.create;

public class CreateUserResponseDTO {
    private long userId;
    private String userName;

    public CreateUserResponseDTO(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
