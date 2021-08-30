package com.clone.animan.controller;

import com.clone.animan.domain.Cart;
import com.clone.animan.dto.CartRequestDto;
import com.clone.animan.security.UserDetailsImpl;
import com.clone.animan.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CartController {

    private final CartService cartService;

    @GetMapping("/cart")
    public List<Cart> getCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.getCart(userDetails.getUsername());
    }

    // 만약 장바구니 등록할려는 상품이 이미 존재했다면 그걸 찾아서 + 해주는 것을 해줘야함
    //
    @PostMapping("/cart/{productId}")
    public void createCart(@PathVariable Long productId, @RequestBody CartRequestDto requestDto) {
        cartService.createCart(productId, requestDto);
    }

    @DeleteMapping("/cart/{productId}")
    public void deleteCart(@PathVariable Long productId) {
        cartService.deleteCart(productId);
    }
}
