package com.neo.e_com.controller;


import com.neo.e_com.dto.ProductDto;
import com.neo.e_com.entity.Product;
import com.neo.e_com.mapper.ProductMapper;
import com.neo.e_com.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Tag(name = "Product APIs" , description = "Operations related to products")
public class ProductController {

    private final ProductService productService;

    public ProductController( ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/all")
    @Operation(summary = "get all products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    @Operation(summary = "add product")
    public ResponseEntity<String> addProduct(
            @Valid @RequestBody ProductDto productDto){


        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "get product by id")
    public ResponseEntity<ProductDto> getProductById(@RequestParam("id") Long id){
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }

    @PostMapping("/bulkUpload")
    @Operation(summary = "bulk upload of Product")
    public ResponseEntity<String> bulkUploadProduct(@RequestBody List<ProductDto> productDtos){

        return new ResponseEntity<>(productService.bulkUploadProduct(productDtos),HttpStatus.CREATED);
    }



}
