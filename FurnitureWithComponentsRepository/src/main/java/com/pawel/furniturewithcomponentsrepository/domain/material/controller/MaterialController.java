package com.pawel.furniturewithcomponentsrepository.domain.material.controller;

import com.pawel.furniturewithcomponentsrepository.domain.material.controller.request.CreateMaterialRequest;
import com.pawel.furniturewithcomponentsrepository.domain.material.exceptions.MaterialAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import com.pawel.furniturewithcomponentsrepository.domain.material.service.MaterialService;
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

import java.util.List;

@RestController
@RequestMapping("api/v1/materials")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class MaterialController {

    private final MaterialService service;

    @PostMapping
    public ResponseEntity<?> saveMaterial(@RequestBody CreateMaterialRequest request) { //TODO add validator for request
        Material material = Material.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        try {
            service.save(material);
        } catch (MaterialAlreadyExistsException me) {
            me.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(me.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Material " + request.getName() + " successfully created.");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Material> findAllMaterials() {
        List<Material> materials = service.findAll();
        log.info("---> Returning all materials: {}", materials.size());
        return materials;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void deleteMaterialById(@PathVariable String id) {
        log.info("---> Removing material by id: {}", id);
        service.removeById(id);
    }
}
