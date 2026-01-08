package com.neo.e_com.service;

import com.neo.e_com.dto.ProductDto;
import com.neo.e_com.entity.Category;
import com.neo.e_com.entity.Product;
import com.neo.e_com.exception.ResourceNotFoundException;
import com.neo.e_com.mapper.ProductMapper;
import com.neo.e_com.repository.CategoryRespository;
import com.neo.e_com.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;
    CategoryRespository categoryRespository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRespository categoryRespository){
        this.productRepository=productRepository;
        this.categoryRespository=categoryRespository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public String addProduct(ProductDto productDto) {
        //get category id
        //get category
        //add category to product and save product
        Category category = categoryRespository.findById(productDto.getCategory_id())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Product product = ProductMapper.toProduct(productDto,category);

        Long id = productRepository.save(product).getId();
        return "Product added with id : " + id;
    }

    @Override
    public ProductDto getProductById(Long id)  {

         Product product = productRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("product not found"));


         return ProductMapper.toProductDto(product);
    }

    @Override
    public String bulkUploadProduct(List<ProductDto> productDtos) {

       /* List<Product> products = new LinkedList<>();


        productDtos.forEach(productDto -> products.add(ProductMapper.toProduct(productDto,)));


       List<Product> productList = productRepository.saveAll(products);

       StringBuilder Ids = new StringBuilder("Products added with ids: ");

       productList.forEach(product -> Ids.append(product.getId()).append(" "));
        return Ids.toString() ;

        */
        return "";
    }
}
