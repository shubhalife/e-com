package com.neo.e_com.controller;

import com.neo.e_com.dto.CategoryDto;
import com.neo.e_com.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@Tag(name = "Category APIs" ,description = "Operations related to category")
public class CategoryController {

    private final CategoryService  categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/bulkUpload")
    @Operation( summary = "Bulk Upload of Category")
    public  ResponseEntity<String> addAllCategory(@RequestBody List<CategoryDto> categoryDtos){

        return  new ResponseEntity<>(categoryService.addAllCategory(categoryDtos), HttpStatus.CREATED);
    }

}
