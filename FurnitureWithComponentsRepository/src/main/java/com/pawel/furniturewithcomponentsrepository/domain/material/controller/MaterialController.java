package com.pawel.furniturewithcomponentsrepository.domain.material.controller;

import com.pawel.furniturewithcomponentsrepository.domain.material.controller.request.AddMaterialRequest;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import com.pawel.furniturewithcomponentsrepository.domain.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/materials")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService service;

    @PostMapping
    public void saveMaterial(@Valid @RequestBody AddMaterialRequest request) {
        Material material = new Material(null, request.getName());
        service.save(material);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Material> findAllMaterials() {
        return service.findAll();
    }
}
