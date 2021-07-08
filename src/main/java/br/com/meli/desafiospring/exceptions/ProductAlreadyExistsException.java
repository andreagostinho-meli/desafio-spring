package br.com.meli.desafiospring.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException() {
        super("There's already a product with the provided id");
    }
}
