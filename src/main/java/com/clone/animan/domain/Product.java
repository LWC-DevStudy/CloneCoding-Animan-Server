package com.clone.animan.domain;

import com.clone.animan.dto.ProductRequestDto;
import com.clone.animan.dto.request.ReviewRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    //https://ict-nroo.tistory.com/125
    @OneToMany
    @JoinColumn(name = "PRODUCT_ID")   // db 만들어질때 어차피 다 대문자로 됨 대소문자 구분 의미없다.
    private List<Image> image = new ArrayList<>();


    public Product(ProductRequestDto productRequestDto) {
        this.title = productRequestDto.getTitle();
        this.price = productRequestDto.getPrice();
        this.category = productRequestDto.getCategory();
        this.image = productRequestDto.getImage();
    }
}
