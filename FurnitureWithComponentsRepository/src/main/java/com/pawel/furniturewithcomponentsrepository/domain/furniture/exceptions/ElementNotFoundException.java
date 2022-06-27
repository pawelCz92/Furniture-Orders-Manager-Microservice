package com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message) {
        super(message);
    }
}
