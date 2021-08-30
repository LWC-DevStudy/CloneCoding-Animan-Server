package com.clone.animan.service;

import com.clone.animan.domain.WishList;
import com.clone.animan.dto.WishListRequestDto;
import com.clone.animan.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WishListService {

    private final WishListRepository wishListRepository;

    public List<WishList> getWishList(String username) {
        return wishListRepository.findAllByUsername(username);
    }

    public void createWishList(Long productId, WishListRequestDto requestDto) {
        WishList wishList = new WishList(requestDto);
        wishListRepository.save(wishList);
    }

    public void deleteWishList(Long productId){
        wishListRepository.deleteById(productId);
    }
}
