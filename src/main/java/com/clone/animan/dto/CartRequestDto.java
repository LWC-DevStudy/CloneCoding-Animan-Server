package com.clone.animan.dto;

import lombok.Getter;

@Getter
public class CartRequestDto {
    private Long quantity;
    private Long productId;
    private String title;
    private Long price;
    private String productImage;
    private String username;
    //private boolean isWished;
}
