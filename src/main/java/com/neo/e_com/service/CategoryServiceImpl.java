package com.neo.e_com.service;

import com.neo.e_com.dto.CategoryDto;
import com.neo.e_com.entity.Category;
import com.neo.e_com.mapper.CategoryMapper;
import com.neo.e_com.repository.CategoryRespository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRespository categoryRespository;

    public CategoryServiceImpl(CategoryRespository categoryRespository) {
        this.categoryRespository = categoryRespository;
    }

    @Override
    public String addAllCategory(List<CategoryDto> categoryDtos) {

       List<Category> categories = new LinkedList<>();

       categoryDtos.forEach(categoryDto -> categories.add(CategoryMapper.toCategory(categoryDto)));

        List<Category> categoryList= categoryRespository.saveAll(categories);

        StringBuilder category_ids = new StringBuilder("Categories created with ids : ");

         categoryList
                .forEach(category -> category_ids.append(category.getId()).append(" "));

        return category_ids.toString() ;
    }
}
