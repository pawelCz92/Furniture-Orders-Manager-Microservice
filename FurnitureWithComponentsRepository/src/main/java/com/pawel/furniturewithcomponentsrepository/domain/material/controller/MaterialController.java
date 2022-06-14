package com.pawel.furniturewithcomponentsrepository.domain.material.controller;

import com.pawel.furniturewithcomponentsrepository.domain.material.controller.request.AddMaterialRequest;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import com.pawel.furniturewithcomponentsrepository.domain.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/materials")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class MaterialController {

    private final MaterialService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveMaterial(@Valid @RequestBody AddMaterialRequest request) {
        Material material = new Material(null, request.getName());
        service.save(material);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Material> findAllMaterials() {
        List<Material> materials = service.findAll();
        log.info("Returning all materials: {}", materials.size());
        return materials;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteMaterialById(@PathVariable String id) {
        log.info("Removing material by id: {}", id);
        service.removeById(id);
    }
}
