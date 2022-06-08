package com.pawel.furniturewithcomponentsrepository.domain.element.controller;

import com.pawel.furniturewithcomponentsrepository.domain.element.controller.dto.ElementDto;
import com.pawel.furniturewithcomponentsrepository.domain.element.controller.request.AddElementRequest;
import com.pawel.furniturewithcomponentsrepository.domain.element.exceptions.ElementAlreadyExistsException;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.element.service.ElementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TransientObjectException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/elements")
@RequiredArgsConstructor
@Slf4j
public class ElementController {

    private final ElementService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveElement(@Valid @RequestBody AddElementRequest request) {
        ElementDto elementDto = ElementDto.builder()
                .furnitureId(request.getFurnitureId())
                .materialId(request.getMaterialId())
                .length(request.getLength())
                .height(request.getHeight())
                .thickness(request.getThickness())
                .suffix(request.getSuffix())
                .description(request.getDescription())
                .build();
        service.save(elementDto);
    }

    @GetMapping
    public List<Element> getAllElements() {
        return service.findAllElements();
    }


    // TODO EXCEPTION HANDLERS, create controller advice. Create "ResponseEntity" and return it when exception (in all controllers)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ElementAlreadyExistsException.class)
    public String handle(ElementAlreadyExistsException ex) {
        log.error(ex.getMessage());
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handle(ConstraintViolationException ex) {
        log.error(ex.getMessage());
        return ex.getCause().getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TransientObjectException.class)
    public String handle(TransientObjectException ex) {
        log.error(ex.getMessage());
        return ex.getMessage();
    }
}
