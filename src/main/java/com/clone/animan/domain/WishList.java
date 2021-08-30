package com.clone.animan.domain;

import com.clone.animan.dto.WishListRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wishListId;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String productImage;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    public WishList(WishListRequestDto requestDto) {
        this.productId = requestDto.getProductId();
        this.price = requestDto.getPrice();
        this.productImage = requestDto.getProductImage();
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
    }
}
