package br.com.meli.desafiospring.dto.user.create;

import javax.validation.constraints.NotBlank;

public class CreateUserRequestDTO {
    @NotBlank
    private String name;

    private boolean seller;

    public CreateUserRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSeller() {
        return seller;
    }

    public void setSeller(boolean seller) {
        this.seller = seller;
    }
}
