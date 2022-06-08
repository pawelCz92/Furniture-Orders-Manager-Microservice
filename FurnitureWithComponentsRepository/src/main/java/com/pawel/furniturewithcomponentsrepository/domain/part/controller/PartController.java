package com.pawel.furniturewithcomponentsrepository.domain.part.controller;

import com.pawel.furniturewithcomponentsrepository.domain.part.controller.request.AddPartRequest;
import com.pawel.furniturewithcomponentsrepository.domain.part.model.Part;
import com.pawel.furniturewithcomponentsrepository.domain.part.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/parts")
public class PartController {

    private final PartService service;


    @PostMapping
    public String savePart(AddPartRequest request) {
        Part part = Part.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        part.addAllElementQuantities(request.getElementQuantities());
        service.save(part);
        return "Successfully added part.";
    }

    // @PostMapping("/{id}/add-el-q/")
}
