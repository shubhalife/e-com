package com.neo.e_com.service;

import com.neo.e_com.dto.ProductDto;
import com.neo.e_com.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    String addProduct(Product product);

    ProductDto getProductById(Long id);
}
