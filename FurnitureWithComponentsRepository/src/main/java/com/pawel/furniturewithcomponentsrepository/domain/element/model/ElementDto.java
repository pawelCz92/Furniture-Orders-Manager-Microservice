package com.pawel.furniturewithcomponentsrepository.domain.element.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElementDto {

    private String furnitureName;
    private String materialName;
    private int length;
    private int height;
    private int thickness;
    private String suffix;
    private String description;
    private boolean removed;
}
