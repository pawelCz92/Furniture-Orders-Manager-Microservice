package com.pawel.furniturewithcomponentsrepository.domain.configurations.model;

import com.pawel.furniturewithcomponentsrepository.domain.furnitures.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.part.model.PartQuantity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "configurations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Furniture furniture;

    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(name = "configurations_and_parts_quantities",
            joinColumns = @JoinColumn(name = "configuration_id"),
            inverseJoinColumns = @JoinColumn(name = "part_quantity_id"))
    private Set<PartQuantity> partAndQuantities;

    public void addAllPartsQuantities(Set<PartQuantity> partAndQuantities) {
        if (this.partAndQuantities == null) {
            this.partAndQuantities = new HashSet<>();
        }
        this.partAndQuantities.addAll(partAndQuantities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(name, that.name) && Objects.equals(furniture, that.furniture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, furniture);
    }
}
