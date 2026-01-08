package com.neo.e_com.mapper;

import com.neo.e_com.dto.CategoryWithProductsDto;
import com.neo.e_com.entity.Category;

public class CategoryWithProductsMapper {

    public static CategoryWithProductsDto toCategoryWithProductDto(Category category){
        return CategoryWithProductsDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .name(category.getName())
                .productDtos(ProductMapper.toProductDtoList(category.getProductList()))
                .build();
    }
}
