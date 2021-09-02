package com.clone.animan.repository;

import com.clone.animan.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByProductIdAndUsername(Long productId, String username);
    List<Cart> findAllByUsername(String username);
}
