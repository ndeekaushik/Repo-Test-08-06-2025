package com.example.microservice3;
import org.junit.jupiter.api.Test;                // JUnit 5 Test annotation
import org.junit.jupiter.api.Assertions;          // JUnit 5 Assertions
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.microservice3.controller.ProductController;
import com.example.microservice3.service.ProductService;
import com.example.microservice3.model.Product;

import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setName("Sample Product");
        product.setPrice(29.99);

        // Simulate ID assignment (you can use any non-null ID for testing purposes)
        product.setId(1L);

        when(productService.createProduct(product)).thenReturn(product);

        Product createdProduct = productController.createProduct(product);

        // Use Assertions.assertNotNull (JUnit 5 version)
        Assertions.assertNotNull(createdProduct.getId(), "Product ID should not be null");

        // Additional assertions
        Assertions.assertEquals("Sample Product", createdProduct.getName());
        Assertions.assertEquals(29.99, createdProduct.getPrice());
    }
}
