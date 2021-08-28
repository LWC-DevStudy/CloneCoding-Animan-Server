package com.clone.animan.repository;


import com.clone.animan.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    Page<Review> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
