package com.pawel.furniturewithcomponentsrepository.domain.furniture.model;

import com.pawel.furniturewithcomponentsrepository.domain.furniture.exceptions.ElementNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Part {

    private String name;
    private String description;
    private Map<String, Integer> elementUuidsWithQuantities = new HashMap<>();
    private int quantityPerConfiguration;

    public Part removeElementByUuid(String uuid){
        Objects.requireNonNull(uuid, "Uuid for remove element from part must not be null");

        if (elementUuidsWithQuantities.remove(uuid) == null){
         throw new ElementNotFoundException("Element with uuid: " + uuid + " not found");
        }
        return this;
    }
}
