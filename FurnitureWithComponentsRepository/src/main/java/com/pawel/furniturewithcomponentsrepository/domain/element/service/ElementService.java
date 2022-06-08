package com.pawel.furniturewithcomponentsrepository.domain.element.service;

import com.pawel.furniturewithcomponentsrepository.domain.element.controller.dto.ElementDto;
import com.pawel.furniturewithcomponentsrepository.domain.element.db.ElementRepo;
import com.pawel.furniturewithcomponentsrepository.domain.element.exceptions.ElementAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions.FurnitureByIdNotFound;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.service.FurnitureService;
import com.pawel.furniturewithcomponentsrepository.domain.material.exceptions.MaterialByIdNotFoundException;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import com.pawel.furniturewithcomponentsrepository.domain.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElementService {

    private final ElementRepo repo;
    private final MaterialService materialService;
    private final FurnitureService furnitureService;

    @Transactional
    public void save(ElementDto elementDto) {
        Material material = materialService.findMaterialById(elementDto.getMaterialId())
                .orElseThrow(() -> new MaterialByIdNotFoundException(elementDto.getMaterialId()));
        Furniture furniture = furnitureService.findFurnitureById(elementDto.getFurnitureId())
                .orElseThrow(() -> new FurnitureByIdNotFound(elementDto.getFurnitureId()));

        Element element = Element.builder()
                .length(elementDto.getLength())
                .height(elementDto.getHeight())
                .thickness(elementDto.getThickness())
                .suffix(elementDto.getSuffix())
                .description(elementDto.getDescription())
                .furniture(furniture)
                .material(material)
                .build();
        if (findByElement(element).isPresent()) {
            throw new ElementAlreadyExistsException("Element already exists");
        }
        repo.save(element);
        log.info("Element: {} successfully added to database.", elementDto);
    }

    private Optional<Element> findByElement(Element element) {
        return repo.findByLengthAndHeightAndThicknessAndSuffixAndDescriptionAndMaterial(element.getLength(),
                element.getHeight(), element.getThickness(), element.getSuffix(), element.getDescription(),
                element.getMaterial());
    }

    public List<Element> findAllElements() {
        return repo.findAll();
    }
}
