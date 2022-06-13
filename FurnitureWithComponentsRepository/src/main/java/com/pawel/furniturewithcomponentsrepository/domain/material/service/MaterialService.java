package com.pawel.furniturewithcomponentsrepository.domain.material.service;

import com.pawel.furniturewithcomponentsrepository.domain.material.db.MaterialRepo;
import com.pawel.furniturewithcomponentsrepository.domain.material.exceptions.MaterialAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepo repo;


    public Material save(Material material) {
        if (findMaterialByName(material.getName()).isPresent()) {
            String message = "Material with name: " + material.getName() + " already exists.";
            throw new MaterialAlreadyExistsException(message);
        }
        return repo.save(material);
    }

    public List<Material> findAll() {
        return repo.findAll();
    }

    public Optional<Material> findMaterialByName(String name) {
        return repo.findByName(name);
    }

    public Optional<Material> findMaterialById(String id) {
        return repo.findById(id);
    }
}
