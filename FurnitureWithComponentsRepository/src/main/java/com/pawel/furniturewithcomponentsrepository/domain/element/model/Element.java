package com.pawel.furniturewithcomponentsrepository.domain.element.model;

import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.material.model.Material;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "elements")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int length = 0;
    private int height = 0;
    private int thickness = 0;
    private String suffix;
    private String description;

    @Setter
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "material_id")
    private Material material;

    @ManyToOne(cascade = CascadeType.DETACH)// TODO (fetch = FetchType.LAZY)
    private Furniture furniture;


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
                ", furniture=" + furniture.getName() +
                ", material=" + material.getName() +
                ", length=" + length +
                ", height=" + height +
                ", thickness=" + thickness +
                ", suffix='" + suffix + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
