package com.pawel.furniturewithcomponentsrepository.domain.furnitures.controller;

import com.pawel.furniturewithcomponentsrepository.domain.furnitures.controller.request.AddFurnitureRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furnitures.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.furnitures.service.FurnitureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/furniture")
@RequiredArgsConstructor
public class FurnitureController {

    private final FurnitureService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String saveFurniture(@Valid @RequestBody AddFurnitureRequest request) {

        Furniture furniture = Furniture.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        furniture.addAllConfigurations(request.getConfigurations());
        service.save(furniture);
        return "Furniture added successfully.";
    }
}
