/*
package com.clone.animan.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String productImage;

    @Column(nullable = false)
    private boolean isWished;

    @Column(nullable = false)
    private Long quantity;

    public Cart(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
*/
