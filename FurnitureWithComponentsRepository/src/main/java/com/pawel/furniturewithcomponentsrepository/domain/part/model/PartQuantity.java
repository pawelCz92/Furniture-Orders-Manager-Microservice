package com.pawel.furniturewithcomponentsrepository.domain.part.model;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parts_and_quantities")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private Configuration configuration;

    @ManyToOne()
    private Part part;
    private int quantity = 0;
}
