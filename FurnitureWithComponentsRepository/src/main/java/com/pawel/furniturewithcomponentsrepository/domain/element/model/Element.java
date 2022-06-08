package com.pawel.furniturewithcomponentsrepository.domain.element.model;

import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "elements")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Element {

    @Id
    private String id;

    private int length = 0;
    private int height = 0;
    private int thickness = 0;
    private String suffix;
    private String description;

    private Material material;

    private String furnitureName;


    public String toShortString() {
        String shortDescr = "";
        if (description != null && description.length() >= 10) {
            shortDescr = description.substring(0, 9).concat("...");
            shortDescr = " -  ShortDescr: " + shortDescr;
        }
        return String.format("%sx%sx%s %s - %s%s",
                length, height, thickness, suffix, material.getName(), shortDescr);
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", furniture=" + furnitureName +
                ", material=" + material.getName() +
                ", length=" + length +
                ", height=" + height +
                ", thickness=" + thickness +
                ", suffix='" + suffix + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
