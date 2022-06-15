package com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions;

public class ElementAlreadyExistException extends RuntimeException {
    public ElementAlreadyExistException(String message) {
        super(message);
    }
}
