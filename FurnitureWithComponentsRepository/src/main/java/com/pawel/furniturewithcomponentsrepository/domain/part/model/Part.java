package com.pawel.furniturewithcomponentsrepository.domain.part.model;

import com.pawel.furniturewithcomponentsrepository.domain.element.model.ElementQuantity;
import com.pawel.furniturewithcomponentsrepository.domain.furnitures.model.Furniture;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Furniture furniture;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(name = "parts_and_elements_quantities",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "element_quantity_id"))
    @ToString.Exclude
    private Set<ElementQuantity> elementQuantities;


    public void addAllElementQuantities(Set<ElementQuantity> elementQuantities) {
        if (this.elementQuantities == null) {
            this.elementQuantities = new HashSet<>();
        }
        this.elementQuantities.addAll(elementQuantities);
    }
}
