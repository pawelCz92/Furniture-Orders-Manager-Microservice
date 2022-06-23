package com.pawel.furniturewithcomponentsrepository.domain.furniture.model.dto;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class FurnitureDto {

    private String name;
    private String description;
    private Set<Configuration> configurations;
    private Set<Element> elements;
}
