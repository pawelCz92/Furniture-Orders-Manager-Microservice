package com.pawel.furniturewithcomponentsrepository.domain.configurations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "configurations_and_quantities")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ConfigurationQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "configuration_id")
    private Configuration configuration;
    private int quantity;
}
