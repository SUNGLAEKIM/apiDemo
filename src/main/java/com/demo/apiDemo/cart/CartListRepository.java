package com.demo.apiDemo.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartListRepository extends JpaRepository<CartList, Long> {

    List<CartList> findAllByCartId(Long cartId);
    void deleteByCartListId(Long cartListId);
}
