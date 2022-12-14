package com.demo.apiDemo.cart;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private Set<CartList> cartLists = new LinkedHashSet<>();

    @Builder
    public Cart(Long cartId, Long memberId, Long totalQuantity, Long totalPrice) {
        this.cartId = cartId;
        this.memberId = memberId;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;

    }
}
