package com.neo.e_com.service;

import com.neo.e_com.dto.CategoryDto;
import com.neo.e_com.dto.CategoryWithProductsDto;
import com.neo.e_com.entity.Category;
import com.neo.e_com.exception.ResourceNotFoundException;
import com.neo.e_com.mapper.CategoryMapper;
import com.neo.e_com.mapper.CategoryWithProductsMapper;
import com.neo.e_com.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String addAllCategory(List<CategoryDto> categoryDtos) {

       List<Category> categories = new LinkedList<>();

       categoryDtos.forEach(categoryDto -> categories.add(CategoryMapper.toCategory(categoryDto)));

        List<Category> categoryList= categoryRepository.saveAll(categories);

        StringBuilder category_ids = new StringBuilder("Categories created with ids : ");

         categoryList
                .forEach(category -> category_ids.append(category.getId()).append(" "));

        return category_ids.toString() ;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return CategoryMapper
                .toCategoryDto(
                        categoryRepository
                                .findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found")));
    }

    @Override
    public CategoryWithProductsDto getCategoryProductsById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));

        return CategoryWithProductsMapper.toCategoryWithProductDto(category);
    }
}
