package com.example.microservice3.service;

import com.example.microservice3.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product createProduct(Product product) {
        product.setId(1L);  // Simulate creating a product
        return product;
    }
}
