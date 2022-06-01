package com.pawel.element.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ElementDto {

    private int length;
    private int height;
    private int thickness;
    private String suffix;
    private String description;
    private Material material;
}
