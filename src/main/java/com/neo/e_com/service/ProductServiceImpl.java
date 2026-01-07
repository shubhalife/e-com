package com.neo.e_com.service;

import com.neo.e_com.entity.Product;
import com.neo.e_com.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public String addProduct(Product product) {
        Long id = productRepository.save(product).getId();
        return "Product added with id : " + id;
    }
}
