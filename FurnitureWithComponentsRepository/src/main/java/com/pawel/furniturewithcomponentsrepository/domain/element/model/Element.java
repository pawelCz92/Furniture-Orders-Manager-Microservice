package com.pawel.furniturewithcomponentsrepository.domain.element.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "elements")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Element {

    private String uuid = UUID.randomUUID().toString();
    private String materialName;
    private int length;
    private int height;
    private int thickness;
    private String suffix;
    @EqualsAndHashCode.Exclude
    private String description;

    @Override
    public String toString() {
        if (suffix == null || suffix.isBlank()) {
            return String.format("(%s) %d x %d x %d", materialName, length, height, thickness);
        }
        return String.format("(%s) %d x %d x %d - %s", materialName, length, height, thickness, suffix);
    }

}
