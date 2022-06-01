package com.pawel.element.controller;

import com.pawel.element.controller.request.AddElementRequest;
import com.pawel.element.exceptions.ElementAlreadyExistsException;
import com.pawel.element.model.Element;
import com.pawel.element.model.ElementDto;
import com.pawel.element.service.ElementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TransientObjectException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/elements")
@RequiredArgsConstructor
@Slf4j
public class ElementController {

    private final ElementService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveElement(@Valid @RequestBody AddElementRequest request) {
        ElementDto dtoFromRequest = getDtoFromRequest(request);
        service.save(Element.fromDto(dtoFromRequest));
    }

    @GetMapping
    public List<ElementDto> getAllElements() {
        return service.findAllElements().stream()
                .map(Element::toDto)
                .collect(Collectors.toList());
    }

    private ElementDto getDtoFromRequest(AddElementRequest request) {
        return ElementDto.builder()
                .length(request.getLength())
                .height(request.getHeight())
                .thickness(request.getThickness())
                .suffix(request.getSuffix())
                .description(request.getDescription())
                .material(request.getMaterial())
                .build();
    }

    // TODO EXCEPTION HANDLERS, create controller advice. Create "ResponseEntity" and return it when exception
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
