package br.com.meli.desafiospring.exceptions;

public class PostAlreadyExistsException extends RuntimeException {
    public PostAlreadyExistsException() {
        super("There's already a post with the provided id");
    }
}
