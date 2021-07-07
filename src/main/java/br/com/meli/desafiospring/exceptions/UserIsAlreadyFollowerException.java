package br.com.meli.desafiospring.exceptions;

public class UserIsAlreadyFollowerException extends RuntimeException {
    public UserIsAlreadyFollowerException() {
        super("You're already following the provided user");
    }
}
