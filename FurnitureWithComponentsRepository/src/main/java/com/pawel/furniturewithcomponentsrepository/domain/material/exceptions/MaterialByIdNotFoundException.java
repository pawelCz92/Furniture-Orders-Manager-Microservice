package com.pawel.furniturewithcomponentsrepository.domain.material.exceptions;

public class MaterialByIdNotFoundException extends RuntimeException {
    public MaterialByIdNotFoundException(Long id) {
        super(String.format("Material by id: %s - not found.", id));
    }
}
