package com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions;

public class FurnitureAlreadyExistsException extends RuntimeException {

    public FurnitureAlreadyExistsException(String message) {
        super(message);
    }
}
