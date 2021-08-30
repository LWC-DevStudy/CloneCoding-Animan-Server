package com.clone.animan.repository;

import com.clone.animan.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface ProductRepository extends JpaRepository<Product, Long > {
    List<Product> findAllByCategory(String category);
    Product findByProductId(Long productId);
}
