package com.neo.e_com.controller;


import com.neo.e_com.dto.ProductDto;
import com.neo.e_com.entity.Product;
import com.neo.e_com.mapper.ProductMapper;
import com.neo.e_com.service.ProductService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController( ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(
            @Validated @RequestBody ProductDto productDto){

            Product product = ProductMapper.toProduct(productDto);

        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

}
