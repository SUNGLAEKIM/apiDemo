package com.demo.apiDemo.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findAllByCartId(Long cartId);
    Optional<Cart> findByMemberId(Long memberId);
    void deleteByCartId(Long cartId);

}
