package com.itwill.ilhajob.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.user.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
