package com.clone.animan.dto;

import lombok.Getter;

@Getter
public class ProductRequestDto {
    private Long productId;
    private String productImage;
    private String title;
    private Long price;
    private String category;

}
