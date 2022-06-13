package com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
public class UpdateFurnitureRequest {

    @NotBlank
    private String id;
    @NotBlank
    private String name;
    private String description;
    @NotEmpty
    private Set<Configuration> configurations;
}
