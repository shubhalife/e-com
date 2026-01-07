package com.neo.e_com.mapper;


import com.neo.e_com.dto.ProductDto;
import com.neo.e_com.entity.Product;

public class ProductMapper {

    public static Product toProduct(ProductDto productDto){
        return Product.builder()
                .name(productDto.getName())
                .build();


    }

    public static  ProductDto toProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }
}
