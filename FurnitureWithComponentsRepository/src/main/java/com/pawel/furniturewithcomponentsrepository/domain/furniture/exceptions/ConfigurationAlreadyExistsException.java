package com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions;

public class ConfigurationAlreadyExistsException extends RuntimeException {
    public ConfigurationAlreadyExistsException(String message) {
        super(message);
    }
}
