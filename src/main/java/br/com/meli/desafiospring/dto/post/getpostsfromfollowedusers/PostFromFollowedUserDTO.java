package br.com.meli.desafiospring.dto.post.getpostsfromfollowedusers;

public class PostFromFollowedUserDTO {
    private int id_post;
    private String date;
    private ProductFromPostDTO detail;

    public PostFromFollowedUserDTO(int id_post, String date, ProductFromPostDTO detail) {
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
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

    public ProductFromPostDTO getDetail() {
        return detail;
    }

    public void setDetail(ProductFromPostDTO detail) {
        this.detail = detail;
    }
}
