package com.neo.e_com.service;

import com.neo.e_com.dto.CategoryDto;
import com.neo.e_com.dto.CategoryWithProductsDto;

import java.util.List;

public interface CategoryService {
    String addAllCategory(List<CategoryDto> categoryDtos);

    CategoryDto getCategoryById(Long id);

    CategoryWithProductsDto getCategoryProductsById(Long id);
}
