package com.clone.animan.controller;

import com.clone.animan.domain.Cart;
import com.clone.animan.domain.WishList;
import com.clone.animan.dto.CartRequestDto;
import com.clone.animan.dto.WishListRequestDto;
import com.clone.animan.security.UserDetailsImpl;
import com.clone.animan.service.CartService;
import com.clone.animan.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class WishListController {

    private final WishListService wishListService;

    @GetMapping("/wish")
    public List<WishList> getWish(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return wishListService.getWishList(userDetails.getUsername());
    }
    // 만약 장바구니 등록할려는 상품이 이미 존재했다면 그걸 찾아서 + 해주는 것을 해줘야함
    //
    @PostMapping("/wish/{productId}")
    public void createWishList(@PathVariable Long productId, @RequestBody WishListRequestDto requestDto) {
        wishListService.createWishList(productId, requestDto);
    }

    @DeleteMapping("/wish/{productId}")
    public void deleteWishList(@PathVariable Long productId) {
        wishListService.deleteWishList(productId);
    }
}
