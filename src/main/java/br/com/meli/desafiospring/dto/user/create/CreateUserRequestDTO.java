package br.com.meli.desafiospring.dto.user.create;

import javax.validation.constraints.NotBlank;

public class CreateUserRequestDTO {
    @NotBlank
    private String name;

    public CreateUserRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
