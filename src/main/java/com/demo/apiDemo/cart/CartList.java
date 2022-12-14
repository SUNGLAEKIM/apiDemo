package com.demo.apiDemo.cart;

import com.demo.apiDemo.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartListId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product product;
    private Long quantity;
    private Long price;

    @Builder
    public CartList(Long cartListId, Cart cart, Product product, Long quantity, Long price) {
        this.cartListId = cartListId;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
