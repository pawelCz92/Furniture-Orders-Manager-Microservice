package com.pawel.furniturewithcomponentsrepository.domain.furniture.service;

import com.pawel.furniturewithcomponentsrepository.domain.common.exception.ObjectNotFoundException;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.AddElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request.RemoveElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.db.FurnitureRepo;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions.ElementAlreadyExistException;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions.FurnitureAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FurnitureService {

    private final FurnitureRepo furnitureRepo;


    public void saveEmpty(Furniture furniture) {
        if (findByName(furniture.getName()).isPresent()) {
            throw new FurnitureAlreadyExistsException("Furniture with name: " + furniture.getName() + " already exists.");
        }
        furnitureRepo.save(furniture);
    }

    public Furniture addElement(AddElementRequest request) {
        Furniture furniture = findFurnitureByName(request.getFurnitureName()).orElseThrow(
                () -> new ObjectNotFoundException("Furniture with name: " + request.getFurnitureName() + " not found."));

        Element element = Element.builder()
                .materialName(request.getMaterialName())
                .length(request.getLength())
                .height(request.getHeight())
                .thickness(request.getThickness())
                .suffix(request.getSuffix())
                .description(request.getDescription())
                .build();
        if (furniture.getElements() != null && furniture.getElements().contains(element)) {
            throw new ElementAlreadyExistException("Element already exist.");
        }
        furniture.addElement(element);
        return update(furniture);
    }

    public Furniture removeElement(RemoveElementRequest request) {
        Furniture furniture = findFurnitureByName(request.getFurnitureName()).orElseThrow(
                () -> new ObjectNotFoundException("Furniture with name: " + request.getFurnitureName() + " not found."));

        Element element = Element.builder()
                .materialName(request.getMaterialName())
                .length(request.getLength())
                .height(request.getHeight())
                .thickness(request.getThickness())
                .suffix(request.getSuffix())
                .build();
        furniture.removeElement(element);
        return update(furniture);
    }

    private Optional<Furniture> findFurnitureByName(String name) {
        return furnitureRepo.findByName(name);
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

    public List<Furniture> findAllFurniture() {
        return furnitureRepo.findAll();
    }

    public void removeFurnitureById(String id) {
        Objects.requireNonNull(id, "Furniture id must not be null for removing.");
        if (findFurnitureById(id).isEmpty()) {
            throw new ObjectNotFoundException("Furniture with id: " + id + " not found.");
        }
        furnitureRepo.deleteById(id);
    }
}
