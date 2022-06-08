package com.pawel.furniturewithcomponentsrepository.domain.element.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElementQuantity {

    private Element element;
    private int quantity;
}
