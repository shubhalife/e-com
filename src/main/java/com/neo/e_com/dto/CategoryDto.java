package com.neo.e_com.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private Long id;

    @NotBlank(message = "Category name is mandatory")
    private String name;
    @NotBlank(message = "Category code is mandatory")
    private  String code;
}
