package com.negotiaition.webservicescontent.controller;

import com.negotiaition.webservicescontent.entity.Product;
import com.negotiaition.webservicescontent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("product")
    public ResponseEntity<Object> retrieveAll() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping("product")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Product created successfully at " + LocalDateTime.now());
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable int id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product with id " + id + " not found at " + LocalDateTime.now());
        }
    }

    @PutMapping("product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Product with id " + id + " updated successfully at " + LocalDateTime.now());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product with id " + id + " not found, update failed at " + LocalDateTime.now());
        }
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Product with id " + id + " deleted successfully at " + LocalDateTime.now());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product with id " + id + " not found, deletion failed at " + LocalDateTime.now());
        }
    }

    @GetMapping("product/name/{name}")
    public Product productFindByName(@PathVariable String name)
    {
        return productService.productFindByName(name);
    }

}
