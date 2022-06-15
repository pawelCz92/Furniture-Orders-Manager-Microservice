package com.pawel.furniturewithcomponentsrepository.domain.furniture.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FurnitureIdNameDescriptionDto {

    String id;
    String name;
    String description;
}
