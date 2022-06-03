package com.pawel.furniturewithcomponentsrepository.domain.furnitures.controller.request;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
public class AddFurnitureRequest {

    @NotBlank
    private String name;
    private String description;
    private Set<Configuration> configurations;
}
