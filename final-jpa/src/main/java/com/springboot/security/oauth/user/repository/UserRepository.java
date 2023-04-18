package com.springboot.security.oauth.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.user.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByNickname(String nickname);
    Optional<User> findByUserEmail(String userEmail);
    boolean existsByUserEmail(String userEmail);
    //Optional<User> findAppListById(Long id);
}
