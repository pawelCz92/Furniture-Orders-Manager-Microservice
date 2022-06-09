package com.pawel.furniturewithcomponentsrepository.domain.part.model;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.ElementQuantity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Part {

    private String name;
    private String description;
    private Set<ElementQuantity> elementQuantities;


    public void addAllElementQuantities(Set<ElementQuantity> elementQuantities) {
        if (this.elementQuantities == null) {
            this.elementQuantities = new HashSet<>();
        }
        this.elementQuantities.addAll(elementQuantities);
    }
}
