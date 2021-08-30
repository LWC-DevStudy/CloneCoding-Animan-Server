package com.clone.animan.dto;

import com.clone.animan.domain.Image;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductRequestDto {
    private Long productId;
    private String title;
    private Long price;
    private String category;
    private List<Image> image;
}
