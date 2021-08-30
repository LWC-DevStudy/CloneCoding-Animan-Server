package com.clone.animan.repository;

import com.clone.animan.domain.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findAllByUsername(String username);
}
