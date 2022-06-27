package com.pawel.furniturewithcomponentsrepository.domain.furniture.model.dto;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.FurnitureConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FurnitureDto {

    private String name;
    private String description;
    private Set<FurnitureConfig> furnitureConfigs;
    private Set<Element> elements;
}
