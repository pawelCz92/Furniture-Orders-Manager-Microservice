package com.pawel.element.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "materials")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String name;

    public MaterialDto toDto() {
        return new MaterialDto(getName());
    }

    public static Material fromDto(MaterialDto materialDto) {
        return new Material(null, materialDto.getName());
    }
}
