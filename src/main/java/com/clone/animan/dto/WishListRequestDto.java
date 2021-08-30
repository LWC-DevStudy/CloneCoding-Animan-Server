package com.clone.animan.dto;

import lombok.Getter;

@Getter
public class WishListRequestDto {
    private Long productId;
    private String title;
    private Long price;
    private String username;
    private String productImage;
}
