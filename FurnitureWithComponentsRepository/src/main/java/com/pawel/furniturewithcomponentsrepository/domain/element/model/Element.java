package com.pawel.furniturewithcomponentsrepository.domain.element.model;

import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "elements")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Element {

    @Id
    @EqualsAndHashCode.Exclude
    private String id;

    private String furnitureName;
    private Material material;
    private int length;
    private int height;
    private int thickness;
    private String suffix;
    private String description;

    public static Element fromDto(ElementDto elementDto, Material material) {
        return Element.builder()
                .furnitureName(elementDto.getFurnitureName())
                .material(material)
                .length(elementDto.getLength())
                .height(elementDto.getHeight())
                .thickness(elementDto.getThickness())
                .suffix(elementDto.getSuffix())
                .description(elementDto.getDescription())
                .build();
    }
}
