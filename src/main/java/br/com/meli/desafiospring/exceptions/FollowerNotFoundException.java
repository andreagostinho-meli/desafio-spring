package br.com.meli.desafiospring.exceptions;

public class FollowerNotFoundException extends RuntimeException {
    public FollowerNotFoundException() {
        super("Follower not found");
    }
}
