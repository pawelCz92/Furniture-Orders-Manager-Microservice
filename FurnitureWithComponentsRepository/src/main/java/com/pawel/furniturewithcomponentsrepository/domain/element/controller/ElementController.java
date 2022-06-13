package com.pawel.furniturewithcomponentsrepository.domain.element.controller;

import com.pawel.furniturewithcomponentsrepository.domain.common.exception.DocumentNotFoundException;
import com.pawel.furniturewithcomponentsrepository.domain.element.controller.request.AddElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.ElementDto;
import com.pawel.furniturewithcomponentsrepository.domain.element.service.ElementService;
import com.pawel.furniturewithcomponentsrepository.domain.element.validator.ElementRequestValidator;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.service.FurnitureService;
import com.pawel.furniturewithcomponentsrepository.domain.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/elements")
@RequiredArgsConstructor
@Slf4j
public class ElementController {

    private final ElementService elementService;
    private final MaterialService materialService;
    private final FurnitureService furnitureService;
    private final ElementRequestValidator elementRequestValidator;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveElement(@RequestBody AddElementRequest request) {
        elementRequestValidator.validateAddElementRequest(request);

        ElementDto elementDto = ElementDto.builder()
                .furnitureName(request.getFurnitureName())
                .materialName(request.getMaterialName())
                .length(request.getLength())
                .height(request.getHeight())
                .thickness(request.getThickness())
                .suffix(request.getSuffix())
                .description(request.getDescription())
                .build();
        elementService.save(elementDto);
    }

    @GetMapping
    public List<Element> getAllElements() {
        return elementService.findAllElements();
    }

    @GetMapping("/view-with-names")
    public List<ElementDto> findAllElementsWithFurnitureAndMaterialNames() {
        return elementService.findAllElements().stream()
                .map(el -> {
                            String furnitureName = furnitureService.findFurnitureById(el.getFurnitureId()).orElseThrow(
                                    () -> new DocumentNotFoundException(
                                            "Furniture with id " + el.getFurnitureId() + " not exists.")).getName();
                            String materialName = materialService.findMaterialById(el.getMaterialId()).orElseThrow(
                                    () -> new DocumentNotFoundException(
                                            "Material with id " + el.getMaterialId() + "not exists")
                            ).getName();
                            return ElementDto.builder()
                                    .furnitureName(furnitureName)
                                    .materialName(materialName)
                                    .length(el.getLength())
                                    .height(el.getHeight())
                                    .thickness(el.getThickness())
                                    .suffix(el.getSuffix())
                                    .description(el.getDescription())
                                    .build();
                        }
                )
                .collect(Collectors.toList());
    }


    // TODO EXCEPTION HANDLERS, create controller advice. Create "ResponseEntity" and return it when exception (in all controllers)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException ex) {
        log.error(ex.getMessage());
        return ex.getMessage();
    }
}
