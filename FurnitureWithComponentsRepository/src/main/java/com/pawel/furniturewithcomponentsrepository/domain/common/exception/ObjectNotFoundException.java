package com.pawel.furniturewithcomponentsrepository.domain.common.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
