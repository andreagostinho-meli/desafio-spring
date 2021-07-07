package br.com.meli.desafiospring.exceptions;

public class SameUserFollowException extends RuntimeException {
    public SameUserFollowException() {
        super("You can't follow or unfollow yourself");
    }
}
