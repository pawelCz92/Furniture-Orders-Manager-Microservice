package com.pawel.furniturewithcomponentsrepository.domain.part.model;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Part {

    private String name;
    private String description;
    private Set<Element> elements;
    private int quantityPerConfiguration;
}
