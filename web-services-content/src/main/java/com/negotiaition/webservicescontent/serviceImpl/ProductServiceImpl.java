package com.negotiaition.webservicescontent.serviceImpl;

import com.negotiaition.webservicescontent.entity.Product;
import com.negotiaition.webservicescontent.repository.ProductRepo;
import com.negotiaition.webservicescontent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;


    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product) {
        // Check if the product exists
        if (productRepo.existsById(id)) {
            product.setId(id);
            return productRepo.save(product);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    public boolean deleteProduct(int id) {
        productRepo.deleteById(id);
        return false;
    }

    public Product productFindByName(String name)
    {
       return productRepo.findByName(name);
    }
}
