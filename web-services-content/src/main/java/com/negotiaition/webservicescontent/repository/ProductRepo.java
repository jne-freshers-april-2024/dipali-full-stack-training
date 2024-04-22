package com.negotiaition.webservicescontent.repository;

import com.negotiaition.webservicescontent.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

     Product findByName(String name);

}
