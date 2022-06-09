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
public class Element implements Comparable<Element> {

    @Id
    @EqualsAndHashCode.Exclude
    private String id;

    private int length;
    private int height;
    private int thickness;
    private String suffix;
    private String description;

    private Material material;

    private String furnitureName;


    public String toShortString() {
        String shortDesc = "";
        if (description != null && description.length() >= 10) {
            shortDesc = description.substring(0, 9).concat("...");
            shortDesc = " -  ShortDescr: " + shortDesc;
        }
        return String.format("%sx%sx%s %s - %s%s",
                length, height, thickness, suffix, material.getName(), shortDesc);
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

    @Override
    public int compareTo(Element o) {
        if (!o.getFurnitureName().equals(this.furnitureName)) {
            return this.furnitureName.compareToIgnoreCase(o.getFurnitureName());
        }
        if (!o.getMaterial().getName().equals(this.material.getName())) {
            return this.material.getName().compareToIgnoreCase(o.getMaterial().getName());
        }
        if (o.getLength() != this.length) {
            return Integer.compare(this.length, o.getLength());
        }
        if (o.getHeight() != this.height) {
            return Integer.compare(this.height, o.getHeight());
        }
        if (o.getThickness() != this.thickness) {
            return Integer.compare(this.thickness, o.getThickness());
        }
        return 0;
    }
}
