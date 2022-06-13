package com.pawel.furniturewithcomponentsrepository.domain.furniture.controller;

import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.AddFurnitureRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.UpdateFurnitureRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.service.FurnitureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/furniture")
@RequiredArgsConstructor
public class FurnitureController {

    private final FurnitureService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String addFurniture(@Valid @RequestBody AddFurnitureRequest request) {
        Furniture furniture = Furniture.builder()
                .name(request.getName())
                .description(request.getDescription())
                .configurations(request.getConfigurations())
                .build();
        service.save(furniture);
        return "Furniture added successfully.";
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public String updateFurniture(@RequestBody UpdateFurnitureRequest request) {
        Furniture furniture = Furniture.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .configurations(request.getConfigurations())
                .build();
        service.update(furniture);
        return "Furniture updated successfully.";
    }
}
