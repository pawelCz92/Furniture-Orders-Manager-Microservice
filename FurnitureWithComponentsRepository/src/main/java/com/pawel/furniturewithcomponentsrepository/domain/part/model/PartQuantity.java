package com.pawel.furniturewithcomponentsrepository.domain.part.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "parts_and_quantities")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Part part;
    private int quantity = 0;
}
