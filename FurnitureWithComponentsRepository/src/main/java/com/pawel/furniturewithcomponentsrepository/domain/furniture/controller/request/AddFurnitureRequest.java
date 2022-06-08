package com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AddFurnitureRequest {

    @NotBlank
    private String name;
    private String description;
    //  private Set<Configuration> configurations;
}
