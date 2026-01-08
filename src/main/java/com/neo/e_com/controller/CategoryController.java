package com.neo.e_com.controller;

import com.neo.e_com.dto.CategoryDto;
import com.neo.e_com.dto.CategoryWithProductsDto;
import com.neo.e_com.entity.Category;
import com.neo.e_com.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    @Operation(summary = "get category by id")
    public ResponseEntity<CategoryDto> getCategoryById(@RequestParam("id") Long id){

        return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.FOUND);
    }

    @GetMapping("/{id}/categoryProducts")
    @Operation(summary = "get category and products by id")
    public ResponseEntity<CategoryWithProductsDto> getCategoryProductsById(@RequestParam("id") Long id){

        return new ResponseEntity<>(categoryService.getCategoryProductsById(id),HttpStatus.FOUND);
    }

}
