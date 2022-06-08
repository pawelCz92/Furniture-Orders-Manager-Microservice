package com.pawel.furniturewithcomponentsrepository.domain.part.model;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.ElementQuantity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "parts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Part {

    @Id
    private String id;

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
