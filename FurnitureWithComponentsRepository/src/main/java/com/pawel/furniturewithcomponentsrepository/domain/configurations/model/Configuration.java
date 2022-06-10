package com.pawel.furniturewithcomponentsrepository.domain.configurations.model;

import com.pawel.furniturewithcomponentsrepository.domain.part.model.Part;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Configuration {

    @EqualsAndHashCode.Include
    private String name;
    private String description;
    private Set<Part> parts;
}
