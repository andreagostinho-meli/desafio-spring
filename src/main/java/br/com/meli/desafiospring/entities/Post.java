package br.com.meli.desafiospring.entities;

public class Post {
    private int id;
    private int userId;
    private String date;
    private Product product;

    public Post(int id, int userId, String date, Product product) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
