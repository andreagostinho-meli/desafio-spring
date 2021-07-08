package br.com.meli.desafiospring.dto.category.create;

import javax.validation.constraints.NotBlank;

public class CreateCategoryRequestDTO {
    @NotBlank
    private String name;

    public CreateCategoryRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
