package com.pawel.furniturewithcomponentsrepository.domain.material.model;

import lombok.*;

import javax.persistence.*;

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
    @Column(unique = true, nullable = false)
    private String name;

}
