package com.pawel.furniturewithcomponentsrepository.domain.furniture.model;

import com.pawel.furniturewithcomponentsrepository.domain.configurations.model.Configuration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Document(collection = "furniture")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Furniture {

    @Id
    private String id;
    private String name;
    private String description;
    private Set<Configuration> configurations;
}
