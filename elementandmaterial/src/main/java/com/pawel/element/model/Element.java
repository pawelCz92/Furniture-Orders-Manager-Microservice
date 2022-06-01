package com.pawel.element.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "elements")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
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
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "material_id")
    private Material material;


    public static ElementDto toDto(Element element) {
        return ElementDto.builder()
                .length(element.getLength())
                .height(element.getHeight())
                .thickness(element.getThickness())
                .suffix(element.getSuffix())
                .description(element.getDescription())
                .material(element.getMaterial())
                .build();
    }

    public static Element fromDto(ElementDto elementDto) {
        return Element.builder()
                .length(elementDto.getLength())
                .height(elementDto.getHeight())
                .thickness(elementDto.getThickness())
                .suffix(elementDto.getSuffix())
                .description(elementDto.getDescription())
                .material(elementDto.getMaterial())
                .build();
    }

    public String toShortString() {
        String shortDescr = "";
        if (description != null && description.length() >= 10){
            shortDescr = description.substring(0, 9).concat("...");
            shortDescr = " -  ShortDescr: " + shortDescr;
        }
        return String.format("%sx%sx%s %s - %s%s",
                length, height, thickness, suffix, material.getName(), shortDescr);
    }
}
