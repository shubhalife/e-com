package com.neo.e_com.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryWithProductsDto {

    private Long id;

    @NotBlank(message = "Category name is mandatory")
    private String name;
    @NotBlank(message = "Category code is mandatory")
    private  String code;

    private List<ProductDto> productDtos;
}
