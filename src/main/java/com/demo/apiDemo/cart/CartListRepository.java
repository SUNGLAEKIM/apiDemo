package com.demo.apiDemo.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartListRepository extends JpaRepository<CartList, Long> {

    void deleteByCartListId(Long cartListId);

}
