package com.clone.animan.service;

import com.clone.animan.domain.Cart;
import com.clone.animan.dto.CartRequestDto;
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

    public List<Cart> getCart(String username) {
        return cartRepository.findAllByUsername(username);
    }

    //가격 계산은 프론트쪽에서 하게 될거임 그냥 가격과 갯수만 내려주자
    public void createCart(Long productId, CartRequestDto requestDto){
//만약 productId가 이미 cart테이블에 존재한다면
        Optional<Cart> productIdCheck = productIdChecker(productId);
        if(productIdCheck.isPresent()) {
            //Cart cart = cartRepository.findCartBy(productId);
            //Long orgQuantity = cart.getQuantity();
            Long quantity = requestDto.getQuantity();
            updateCart(productId, quantity);
        }
        else {
            Cart cart = new Cart(requestDto);
            cartRepository.save(cart);
        }
    }


    private Optional<Cart> productIdChecker(Long productId) {
        return cartRepository.findById(productId);
    }

    private void updateCart(Long productId, Long quantity) {
        Cart cart = cartRepository.findByProductId(productId);
        Long orgQuantity = cart.getQuantity();
        quantity += orgQuantity;
        cart.update(quantity);
    }

    public void deleteCart(Long productId){
        cartRepository.deleteById(productId);
    }
}

