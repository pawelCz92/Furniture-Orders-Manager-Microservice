package com.pawel.furniturewithcomponentsrepository.domain.material.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateMaterialRequest {

    private String name;
    private String description;
}
