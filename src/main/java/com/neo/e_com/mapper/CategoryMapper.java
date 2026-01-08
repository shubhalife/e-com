package com.neo.e_com.mapper;

import com.neo.e_com.dto.CategoryDto;
import com.neo.e_com.entity.Category;

public class CategoryMapper {

    public static Category toCategory(CategoryDto categoryDto){

        return Category.builder()
                .name(categoryDto.getName())
                .code(categoryDto.getCode())
                .build();
    }

    public static CategoryDto toCategoryDto(Category category){
        return  CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .code(category.getCode())
                .build();
    }
}
