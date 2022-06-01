package com.pawel.element.controller.request;

import com.pawel.element.model.Material;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddElementRequest {


    @Min(value = 0, message = "Element length must not be less than 0")
    private int length;
    @Min(value = 0, message = "Element height must not be less than 0")
    private int height;
    @Min(value = 0, message = "Element thickness must not be less than 0")
    private int thickness;
    private String suffix;
    private String description;
    @NotNull
    private Material material;

}
