package com.pawel.furniturewithcomponentsrepository.domain.furniture.controller.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemoveElementRequest {

    private String furnitureId;
    private String materialId;
    private int length;
    private int height;
    private int thickness;
    private String suffix;
}
