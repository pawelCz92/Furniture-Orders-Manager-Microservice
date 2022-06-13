package com.pawel.furniturewithcomponentsrepository.domain.element.service;

import com.pawel.furniturewithcomponentsrepository.domain.element.db.ElementRepo;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.ElementDto;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import com.pawel.furniturewithcomponentsrepository.domain.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElementService {

    private final ElementRepo repo;
    private final MaterialService materialService;
    private final Fur


    public List<Element> findAllElements() {
        return repo.findAll();
    }

    public Element save(ElementDto elementDto) {
        if (findBy(elementDto).isPresent()) {
            throw new IllegalArgumentException("Element already exist.");
        }

        Material material = materialService.findMaterialByName(elementDto.getMaterialName()).orElseThrow(
                () -> new IllegalArgumentException("Material: " + elementDto.getMaterialName()));
        if ()
            return repo.save(Element.fromDto(elementDto, material));
    }

    private Optional<Element> findBy(ElementDto elementDto) {
        return repo.findByFurnitureNameAndMaterialNameAndLengthAndHeightAndThicknessAndSuffix(
                elementDto.getFurnitureName(),
                elementDto.getMaterialName(),
                elementDto.getLength(),
                elementDto.getHeight(),
                elementDto.getThickness(),
                elementDto.getSuffix());
    }
}
