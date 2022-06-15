package com.pawel.furniturewithcomponentsrepository.domain.furniture.controller;

import com.pawel.furniturewithcomponentsrepository.domain.common.exception.ObjectNotFoundException;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.AddElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.CreateEmptyFurniture;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.RemoveElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions.ElementAlreadyExistException;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions.FurnitureAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.dto.FurnitureIdNameDescriptionDto;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.service.FurnitureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/furnitures")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class FurnitureController {

    private final FurnitureService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-empty")
    public ResponseEntity<?> addEmptyFurniture(@RequestBody CreateEmptyFurniture request) { // TODO add validator
        log.info("---> Create empty furniture: name: {}, descr: {}", request.getName(), request.getDescription());
        try {
            Furniture furniture = Furniture.builder()
                    .name(request.getName())
                    .description(request.getDescription())
                    .configurations(new HashSet<>()).build();
            service.saveEmpty(furniture);
            return ResponseEntity.ok().build();
        } catch (FurnitureAlreadyExistsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/add-element")
    public ResponseEntity<?> addElement(@RequestBody AddElementRequest request) { // TODO add validator
        try {
            return ResponseEntity.ok(service.addElement(request));
        } catch (ElementAlreadyExistException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/remove-element")
    public Furniture removeElement(RemoveElementRequest request) { // TODO add validator
        return service.removeElement(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/names-descriptions")
    public List<FurnitureIdNameDescriptionDto> getFurnitureNamesAndDescriptions() {
        return service.findAllFurniture().stream()
                .map(Furniture::toFurnitureIdNamesDescriptionsDto)
                .sorted((f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeFurniture(@PathVariable String id) {
        try {
            service.removeFurnitureById(id);
            return ResponseEntity.ok().build();
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
