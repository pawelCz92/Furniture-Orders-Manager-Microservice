package com.pawel.furniturewithcomponentsrepository.domain.material.exceptions;

public class MaterialAlreadyExistsException extends RuntimeException {
    public MaterialAlreadyExistsException(String message) {
        super(message);
    }
}
