package com.pawel.element.controller;

import com.pawel.element.controller.request.AddElementRequest;
import com.pawel.element.model.ElementDto;
import com.pawel.element.service.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1/elements")
@RequiredArgsConstructor
public class ElementController {

    private final ElementService service;

    @PostMapping
    public void saveElement(@RequestBody AddElementRequest request) {
    }

    @GetMapping
    public Set<ElementDto> getAllElements() {
        return null;
    }
}
