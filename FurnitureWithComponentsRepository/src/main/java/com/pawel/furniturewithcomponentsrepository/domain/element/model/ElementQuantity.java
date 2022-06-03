package com.pawel.furniturewithcomponentsrepository.domain.element.model;

import javax.persistence.*;

@Entity
@Table(name = "elements_and_quantities")
public class ElementQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Element element;

    private Integer quantity;
}
