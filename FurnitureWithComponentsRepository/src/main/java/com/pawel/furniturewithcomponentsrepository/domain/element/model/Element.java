package com.pawel.furniturewithcomponentsrepository.domain.element.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "elements")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Element {

    private String furnitureId;
    private String materialId;
    private int length;
    private int height;
    private int thickness;
    private String suffix;
    @EqualsAndHashCode.Exclude
    private String description;


}
