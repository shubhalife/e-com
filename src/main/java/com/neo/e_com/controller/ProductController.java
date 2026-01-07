package com.neo.e_com.controller;


import com.neo.e_com.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {



    public ResponseEntity<List<Product>> getProducts(){
        return null;
    }
}
