package com.pawel.furniturewithcomponentsrepository.domain.part.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartQuantity {

    private Part part;
    private int quantity = 0;
}
