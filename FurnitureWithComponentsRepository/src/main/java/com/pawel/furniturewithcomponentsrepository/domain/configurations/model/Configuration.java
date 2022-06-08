package com.pawel.furniturewithcomponentsrepository.domain.configurations.model;

import com.pawel.furniturewithcomponentsrepository.domain.furniture.model.Furniture;
import com.pawel.furniturewithcomponentsrepository.domain.part.model.PartQuantity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Document(collection = "configurations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Configuration {

    @Id
    private String id;
    private String name;
    private String description;
    private Furniture furniture;
    @ToString.Exclude
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
