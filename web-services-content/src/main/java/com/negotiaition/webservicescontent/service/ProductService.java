package com.negotiaition.webservicescontent.service;

import com.negotiaition.webservicescontent.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    public List<Product> getAllProducts();

    public Product createProduct(Product product);

    public Optional<Product> getProductById(int id);

    public Product updateProduct(int id, Product product);

    public boolean deleteProduct(int id);

    public Product productFindByName(String name);


}
