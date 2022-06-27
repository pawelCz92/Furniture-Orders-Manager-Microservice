package com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions;

public class FurnitureNotFoundException extends RuntimeException {
    public FurnitureNotFoundException(String message) {
        super(message);
    }
}
