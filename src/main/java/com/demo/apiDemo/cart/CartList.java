package com.demo.apiDemo.cart;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartListId;
    private Long cartId;
    private Long productId;
    private Long quantity;
    private Long price;

    @Builder
    public CartList(Long cartListId, Long cartId, Long productId, Long quantity, Long price) {
        this.cartListId = cartListId;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
