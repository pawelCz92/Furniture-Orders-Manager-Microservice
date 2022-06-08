package com.pawel.furniturewithcomponentsrepository.domain.element.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElementDto {

    private int length;
    private int height;
    private int thickness;
    private String suffix;
    private String description;
    private Long materialId;
    private Long furnitureId;
}
