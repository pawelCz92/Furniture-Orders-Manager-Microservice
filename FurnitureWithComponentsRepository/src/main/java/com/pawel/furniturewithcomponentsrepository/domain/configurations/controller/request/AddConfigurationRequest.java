package com.pawel.furniturewithcomponentsrepository.domain.configurations.controller.request;

import com.pawel.furniturewithcomponentsrepository.domain.furnitures.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.part.model.PartQuantity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
public class AddConfigurationRequest {

    @NotBlank(message = "Configuration must not have blank name.")
    private String name;
    private String description;
    private Furniture furniture;
    private Set<PartQuantity> partAndQuantities;
}
