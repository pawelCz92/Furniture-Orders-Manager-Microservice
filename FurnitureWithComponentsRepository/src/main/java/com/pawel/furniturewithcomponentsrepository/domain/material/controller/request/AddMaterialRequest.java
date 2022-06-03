package com.pawel.furniturewithcomponentsrepository.domain.material.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddMaterialRequest {

    @NotBlank(message = "Material name must not be blank or null.")
    private String name;
}
