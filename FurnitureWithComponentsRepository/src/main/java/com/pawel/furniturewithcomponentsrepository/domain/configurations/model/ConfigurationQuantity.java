package com.pawel.furniturewithcomponentsrepository.domain.configurations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ConfigurationQuantity {

    private Configuration configuration;
    private int quantity;
}
