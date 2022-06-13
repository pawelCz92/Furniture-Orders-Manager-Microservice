package com.pawel.furniturewithcomponentsrepository.domain.element.validator;

import com.pawel.furniturewithcomponentsrepository.domain.element.controller.request.AddElementRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ElementRequestValidator { // TODO add logs here

    public void validateAddElementRequest(AddElementRequest request) {
        Objects.requireNonNull(request, "Request must not be null");
        List<String> errors = new ArrayList<>();
        if (request.getFurnitureId() == null || request.getFurnitureId().isBlank()) {
            errors.add("Furniture name must not be null or empty");
        }
        if (request.getMaterialId() == null || request.getMaterialId().isBlank()) {
            errors.add("Material ID must not be null or empty");
        }
        if (request.getLength() < 1) {
            errors.add("Length must not by less than 1");
        }
        if (request.getHeight() < 1) {
            errors.add("Height must not by less than 1");
        }
        if (request.getThickness() < 1) {
            errors.add("Thickness must not by less than 1");
        }

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Invalid AddElementRequest: " + errors);
        }
    }
}