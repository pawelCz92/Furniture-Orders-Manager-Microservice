package com.pawel.furniturewithcomponentsrepository.domain.configurations.controller;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.controller.request.AddConfigurationRequest;
import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import com.pawel.furniturewithcomponentsrepository.domain.configurations.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/configurations")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addConfiguration(@Valid @RequestBody AddConfigurationRequest request) {
        Configuration configuration = Configuration.builder()
                .name(request.getName())
                .description(request.getDescription())
                .furniture(request.getFurniture())
                .build();
        configuration.addAllPartsQuantities(request.getPartAndQuantities());
        service.save(configuration);
        return "Configuration added successfully.";
    }
}
