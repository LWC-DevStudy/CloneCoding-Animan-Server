/*
package com.clone.animan.service;

import com.clone.animan.domain.Cart;
import com.clone.animan.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;

*/
/*

    public List<Cart> getCart(User user) {
        String username = user.getUsername();
        return cartRepository.findAllByUsername(username);
    }
*//*


*/
/*    //가격 계산은 프론트쪽에서 하게 될거임 그냥 가격과 갯수만 내려주자
    public void createCart(Long quantity, Long productId){
//만약 productId가 이미 cart테이블에 존재한다면
        Optional<Cart> productIdCheck = productIdChecker(productId);

        if(productIdCheck.isPresent()) {
           Cart cart = cartRepository.findCartBy(productId);
           Long orgQuantity = cart.getQuantity();
           updateCart(orgQuantity, quantity);
        }

        else {
            Cart cart = new Cart(quantity, productId);
            cartRepository.save(cart);
        }
    }*//*


    private Optional<Cart> productIdChecker(Long productId) {
        return cartRepository.findById(productId);
    }

    private Long updateCart(Long orgQuantity, Long quantity) {
        quantity += orgQuantity;
        return quantity;
    }

    public void deleteCart(Long productId){
        cartRepository.deleteById(productId);
    }
}

*/
