package com.pawel.furniturewithcomponentsrepository.domain.furniture.model;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
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


@Document(collection = "furniture")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Furniture {

    @Id
    private String id;

    private String name;
    private String description;
    private Set<Configuration> configurations;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Objects.equals(name, furniture.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addAllConfigurations(Set<Configuration> configurations) {
        if (this.configurations == null) {
            this.configurations = new HashSet<>();
        }
        this.configurations.addAll(configurations);
    }
}
