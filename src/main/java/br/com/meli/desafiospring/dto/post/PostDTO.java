package br.com.meli.desafiospring.dto.post;

import br.com.meli.desafiospring.dto.product.ProductDTO;

public class PostDTO {
    private int userId;
    private int id_post;
    private String date;
    private ProductDTO detail;

    public PostDTO(int userId, int id_post, String date, ProductDTO detail) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
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
