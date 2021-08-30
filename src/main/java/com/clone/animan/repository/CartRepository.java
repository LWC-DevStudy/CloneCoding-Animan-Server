package com.clone.animan.repository;

import com.clone.animan.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByProductId(Long productId);
    List<Cart> findAllByUsername(String username);
}
