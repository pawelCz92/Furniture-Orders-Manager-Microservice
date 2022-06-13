package com.pawel.furniturewithcomponentsrepository.domain.furniture.service;

import com.pawel.furniturewithcomponentsrepository.domain.furniture.db.FurnitureRepo;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FurnitureService {

    private final FurnitureRepo repo;


    public Furniture save(Furniture furniture) {
        if (findByName(furniture.getName()).isPresent()) {
            String message = "Furniture with name: " + furniture.getName() + " already exists.";
            throw new IllegalArgumentException(message);
        }
        return repo.save(furniture);
    }

    private Optional<Furniture> findByName(String name) {
        return repo.findByName(name);
    }

    public Optional<Furniture> findFurnitureById(String id) {
        return repo.findById(id);
    }

    public Optional<Furniture> findFurnitureByName(String name) {
        return repo.findByName(name);
    }

    public void update(Furniture furniture) {
        Objects.requireNonNull(furniture, "Furniture for update must not be null");
        if (findFurnitureById(furniture.getId()).isEmpty()) {
            throw new IllegalArgumentException("Furniture with id: " + furniture.getId() + " not exists.");
        }
        repo.save(furniture);
    }
}