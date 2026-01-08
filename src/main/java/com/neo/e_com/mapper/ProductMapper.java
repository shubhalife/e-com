package com.neo.e_com.mapper;


import com.neo.e_com.dto.ProductDto;
import com.neo.e_com.entity.Category;
import com.neo.e_com.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product toProduct(ProductDto productDto, Category category){
        return Product.builder()
                .name(productDto.getName())
                .category(category)
                .build();


    }

    public static  ProductDto toProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .category_id(product.getCategory().getId())
                .build();
    }

    public static List<ProductDto> toProductDtoList(List<Product> products){

        List<ProductDto> productDtos  = new ArrayList<>();

        products.forEach(product -> productDtos.add(ProductMapper.toProductDto(product)));
        return productDtos;
    }
}
