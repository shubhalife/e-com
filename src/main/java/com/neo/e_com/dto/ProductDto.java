package com.neo.e_com.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {

    private Long id;

    @NotBlank(message = "Product name is mandatory")
    private String name;

    private Long category_id;

}
