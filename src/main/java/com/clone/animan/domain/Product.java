package com.clone.animan.domain;

import com.clone.animan.dto.ProductRequestDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String category;

    @NotNull
    @Column(nullable = false)
    private String productImage;

    public Product(ProductRequestDto productRequestDto) {
        this.title = productRequestDto.getTitle();
        this.price = productRequestDto.getPrice();
        this.category = productRequestDto.getCategory();
        this.productImage = productRequestDto.getProductImage();
    }
}
