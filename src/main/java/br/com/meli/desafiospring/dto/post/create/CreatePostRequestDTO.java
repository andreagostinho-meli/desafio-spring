package br.com.meli.desafiospring.dto.post.create;

import br.com.meli.desafiospring.dto.product.ProductDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreatePostRequestDTO {
    @NotNull
    private int userId;

    @NotNull
    private int id_post;

    @NotBlank
    private String date;

    @NotNull
    private ProductDTO detail;

    public CreatePostRequestDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ProductDTO getDetail() {
        return detail;
    }

    public void setDetail(ProductDTO detail) {
        this.detail = detail;
    }
}
