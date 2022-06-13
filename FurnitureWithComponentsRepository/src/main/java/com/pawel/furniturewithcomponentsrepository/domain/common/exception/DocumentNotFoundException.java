package com.pawel.furniturewithcomponentsrepository.domain.common.exception;

public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException(String message) {
        super(message);
    }
}
