package com.pawel.furniturewithcomponentsrepository.domain.furniture.service;

import com.pawel.furniturewithcomponentsrepository.domain.furniture.db.FurnitureRepo;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions.FurnitureAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FurnitureService {

    private final FurnitureRepo repo;


    public void save(Furniture furniture) {
        log.info("Saving furniture with name: {}", furniture.getName());
        if (findByName(furniture.getName()).isPresent()) {
            String message = "Furniture with name: " + furniture.getName() + " already exists.";
            log.error(message);
            throw new FurnitureAlreadyExistsException(message);
        }
        repo.save(furniture);
        log.info("Saved furniture with name: {}", furniture.getName());
    }

    private Optional<Furniture> findByName(String name) {
        return repo.findByName(name);
    }

    public Optional<Furniture> findFurnitureById(Long id) {
        return repo.findById(id);
    }

    public Optional<Furniture> findFurnitureByName(String name) {
        return repo.findByName(name);
    }
}
