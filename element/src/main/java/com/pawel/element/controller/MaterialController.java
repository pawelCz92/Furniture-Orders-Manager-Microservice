package com.pawel.element.controller;

import com.pawel.element.controller.request.AddMaterialRequest;
import com.pawel.element.model.Material;
import com.pawel.element.model.MaterialDto;
import com.pawel.element.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/materials")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService service;

    @PostMapping
    public void saveMaterial(@Valid @RequestBody AddMaterialRequest request) {
        MaterialDto materialDto = new MaterialDto(request.getName());
        service.save(Material.fromDto(materialDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<MaterialDto> findAllMaterials() {
        return service.findAll().stream()
                .map(Material::toDto)
                .collect(Collectors.toList());
    }
}
