package com.demo.apiDemo.cart;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private Long memberId;
    private Long totalQuantity;
    private Long totalPrice;
    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public Cart(Long cartId, Long memberId, Long totalQuantity, Long totalPrice) {
        this.cartId = cartId;
        this.memberId = memberId;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;

    }
}
