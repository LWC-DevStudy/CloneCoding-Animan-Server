package com.clone.animan.service;


import com.clone.animan.domain.Product;
import com.clone.animan.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts(String category) {
        if(category.equals("all")) {
            return productRepository.findAll();
        }
        else {
            return productRepository.findAllByCategory(category);
        }
    }
}
