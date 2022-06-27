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

    private String furnitureName;
    private String elementUuid;
}
