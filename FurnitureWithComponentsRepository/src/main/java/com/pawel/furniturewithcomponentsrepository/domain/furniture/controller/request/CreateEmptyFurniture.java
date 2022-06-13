package com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateEmptyFurniture {

    private String name;
    private String description;

}
