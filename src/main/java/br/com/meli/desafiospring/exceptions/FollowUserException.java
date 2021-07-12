package br.com.meli.desafiospring.exceptions;

public class FollowUserException extends RuntimeException {
    public FollowUserException() {
        super("You can't follow a user other than a seller");
    }
}
