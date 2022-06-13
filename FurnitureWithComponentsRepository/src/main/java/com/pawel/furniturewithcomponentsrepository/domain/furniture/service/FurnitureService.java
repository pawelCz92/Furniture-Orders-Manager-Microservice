package com.pawel.furniturewithcomponentsrepository.domain.furniture.service;

import com.pawel.furniturewithcomponentsrepository.domain.common.exception.ObjectNotFoundException;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.AddElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.RemoveElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.db.FurnitureRepo;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FurnitureService {

    private final FurnitureRepo furnitureRepo;
    private final MaterialService materialService;


    public Furniture saveEmpty(Furniture furniture) {
        if (findByName(furniture.getName()).isPresent()) {
            throw new IllegalArgumentException("Furniture with name: " + furniture.getName() + " already exists.");
        }
        return furnitureRepo.save(furniture);
    }

    public Furniture addElement(AddElementRequest request) {
        Furniture furniture = findFurnitureById(request.getFurnitureId()).orElseThrow(
                () -> new ObjectNotFoundException("Furniture with id: " + request.getFurnitureId() + " not found."));

        if (materialService.findMaterialById(request.getMaterialId()).isEmpty()) {
            throw new ObjectNotFoundException("Material with id: " + request.getMaterialId() + " not found");
        }
        Element element = Element.builder()
                .furnitureId(request.getFurnitureId())
                .materialId(request.getMaterialId())
                .length(request.getLength())
                .height(request.getHeight())
                .thickness(request.getThickness())
                .suffix(request.getSuffix())
                .description(request.getDescription())
                .build();
        furniture.addElement(element);
        return update(furniture);
    }

    public Furniture removeElement(RemoveElementRequest request) {
        Furniture furniture = findFurnitureById(request.getFurnitureId()).orElseThrow(
                () -> new ObjectNotFoundException("Furniture with id: " + request.getFurnitureId() + " not found."));

        if (materialService.findMaterialById(request.getMaterialId()).isEmpty()) {
            throw new ObjectNotFoundException("Material with id: " + request.getMaterialId() + " not found");
        }
        Element element = Element.builder()
                .furnitureId(request.getFurnitureId())
                .materialId(request.getMaterialId())
                .length(request.getLength())
                .height(request.getHeight())
                .thickness(request.getThickness())
                .suffix(request.getSuffix())
                .build();
        furniture.removeElement(element);
        return update(furniture);
    }

    private Furniture update(Furniture furniture) {
        Objects.requireNonNull(furniture, "Furniture for update must not be null!");
        return furnitureRepo.save(furniture);
    }


    private Optional<Furniture> findByName(String name) {
        return furnitureRepo.findByName(name);
    }

    public Optional<Furniture> findFurnitureById(String id) {
        return furnitureRepo.findById(id);
    }
}
