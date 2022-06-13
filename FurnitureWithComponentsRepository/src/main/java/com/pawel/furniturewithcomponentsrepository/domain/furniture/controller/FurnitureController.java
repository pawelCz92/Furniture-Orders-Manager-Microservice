package com.pawel.furniturewithcomponentsrepository.domain.furniture.controller;

import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.AddElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.CreateEmptyFurniture;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.RemoveElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.service.FurnitureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping("api/v1/furniture")
@RequiredArgsConstructor
public class FurnitureController {

    private final FurnitureService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-empty")
    public Furniture addEmptyFurniture(@RequestBody CreateEmptyFurniture request) { // TODO add validator
        Furniture furniture = Furniture.builder()
                .name(request.getName())
                .description(request.getDescription())
                .configurations(new HashSet<>()).build();
        return service.saveEmpty(furniture);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/add-element")
    public Furniture addElement(@RequestBody AddElementRequest request) { // TODO add validator
        return service.addElement(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/remove-element")
    public Furniture removeElement(RemoveElementRequest request) { // TODO add validator
        return service.removeElement(request);
    }
}
