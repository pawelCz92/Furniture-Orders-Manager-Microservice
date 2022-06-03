package com.pawel.furniturewithcomponentsrepository.domain.part.controller.request;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.ElementQuantity;
import lombok.Data;

import java.util.Set;

@Data
public class AddPartRequest {

    private String name;
    private String description;
    private Set<ElementQuantity> elementQuantities;
}
