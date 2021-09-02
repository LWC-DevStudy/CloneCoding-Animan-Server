package com.clone.animan.service;

import com.clone.animan.domain.Cart;
import com.clone.animan.dto.CartRequestDto;
import com.clone.animan.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        //username도 추가해서 같이 찾아야함
        String username = requestDto.getUsername();
        Cart productIdAndUsernameCheck = productIdAndUsernameChecker(username, productId);
        if(productIdAndUsernameCheck != null) {
            Long quantity = requestDto.getQuantity();
            updateCart(username, productId, quantity);
        }
        else {
            Cart cart = new Cart(requestDto);
            cartRepository.save(cart);
        }
    }

    private Cart productIdAndUsernameChecker(String username, Long productId) {
        return cartRepository.findByProductIdAndUsername(productId, username);
    }

    @Transactional
    public void updateCart(String username, Long productId, Long quantity) {
        Cart cart = cartRepository.findByProductIdAndUsername(productId, username);
        Long orgQuantity = cart.getQuantity();
        quantity += orgQuantity;
        cart.update(quantity);
        cartRepository.save(cart);
    }

    public void updateQuantityCart(Long productId, CartRequestDto requestDto) {
        String username = requestDto.getUsername();
        Long quantity = requestDto.getQuantity();
        Cart cart = cartRepository.findByProductIdAndUsername(productId, username);
        cart.update(quantity);
        cartRepository.save(cart);
    }

    public void deleteCart(Long cartId){
        cartRepository.deleteById(cartId);
    }
}

