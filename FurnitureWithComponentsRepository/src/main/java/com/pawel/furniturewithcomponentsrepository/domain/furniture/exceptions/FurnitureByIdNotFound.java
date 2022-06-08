package com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions;

public class FurnitureByIdNotFound extends RuntimeException {
    public FurnitureByIdNotFound(Long id) {
        super(String.format("Furniture by id: %s - not found.", id));
    }
}
