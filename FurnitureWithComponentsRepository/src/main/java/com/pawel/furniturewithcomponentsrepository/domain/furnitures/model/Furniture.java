package com.pawel.furniturewithcomponentsrepository.domain.furnitures.model;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "furniture")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String description;

    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(name = "furniture_and_configurations",
            joinColumns = @JoinColumn(name = "furniture_id"),
            inverseJoinColumns = @JoinColumn(name = "configuration_id"))
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
