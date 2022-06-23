package com.pawel.furniturewithcomponentsrepository.domain.furniture.model;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import com.pawel.furniturewithcomponentsrepository.domain.element.model.Element;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.dto.FurnitureDto;
import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.dto.FurnitureIdNameDescriptionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Document(collection = "furniture")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Furniture {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;
    private Set<Configuration> configurations = new HashSet<>();
    private Set<Element> elements = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Objects.equals(name, furniture.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addElement(Element element) {
        Objects.requireNonNull(element, "Element to add to furniture (" + name + ") must not be null");
        elements.add(element);
    }

    public void removeElement(Element element) {
        Objects.requireNonNull(element, "Element for remove from Furniture: " + name + " must not be null.");
        if (elements.isEmpty() || !elements.contains(element)) {
            throw new IllegalArgumentException("Elements in furniture: " + name + " are null, empty or not contain " +
                    "given element to remove");
        }
    }

    public FurnitureIdNameDescriptionDto toFurnitureIdNamesDescriptionsDto() {
        return FurnitureIdNameDescriptionDto.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .build();
    }

    public FurnitureDto toDto() {
        return FurnitureDto.builder()
                .name(this.name)
                .description(this.description)
                .configurations(new HashSet<>(this.configurations))
                .elements(new HashSet<>(elements))
                .build();
    }
}
