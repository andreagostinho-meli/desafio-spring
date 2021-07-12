package br.com.meli.desafiospring.entities;

import java.util.List;

public class User {
    private int id;
    private String name;
    private boolean seller;
    private List<User> followers;
    private List<User> following;

    public User(int id, String name, boolean seller, List<User> followers, List<User> following) {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.followers = followers;
        this.following = following;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }
}
