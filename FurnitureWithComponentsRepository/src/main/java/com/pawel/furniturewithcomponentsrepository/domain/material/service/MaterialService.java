package com.pawel.furniturewithcomponentsrepository.domain.material.service;

import com.pawel.furniturewithcomponentsrepository.domain.material.db.MaterialRepo;
import com.pawel.furniturewithcomponentsrepository.domain.material.exceptions.MaterialAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MaterialService {

    private final MaterialRepo repo;

    @Transactional
    public void save(Material material) {
        if (findMaterialByName(material.getName()).isPresent()) {
            String message = "Material with name: " + material.getName() + " already exists.";
            log.warn(message);
            throw new MaterialAlreadyExistsException(message);
        }
        log.info("Saving material: {}", material.getName());
        repo.save(material);
        log.info("Saved material: {}", material);
    }

    public List<Material> findAll() {
        return repo.findAll();
    }

    public Optional<Material> findMaterialByName(String name) {
        return repo.findByName(name);
    }
}
