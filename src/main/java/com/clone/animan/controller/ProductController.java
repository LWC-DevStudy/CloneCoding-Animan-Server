package com.clone.animan.controller;

import com.clone.animan.domain.Product;
import com.clone.animan.repository.ProductRepository;
import com.clone.animan.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    // 주소가 겹쳐서 문제가 생긴것 같아요

    @GetMapping("/product/category/{category}")
    public List<Product> getProductCategory(@PathVariable String category) {
        return productService.getProducts(category);
    }

    @GetMapping("/product/id/{productId}")
    public Product getProduct(@PathVariable Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("해당 Id가 존재하지 않습니다."));
    }
}
