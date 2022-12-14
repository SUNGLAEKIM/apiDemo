package com.demo.apiDemo.cart;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class Request {
        private Long cartId;
        private Long memberId;
        private Long totalQuantity;
        private Long totalPrice;
        private LocalDateTime createdAt;

        public Cart toEntity() {
            Cart cart = Cart.builder()
                    .cartId(cartId)
                    .memberId(memberId)
                    .totalQuantity(totalQuantity)
                    .totalPrice(totalPrice)
                    .build();
            return cart;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long cartId;
        private Long memberId;
        private Long totalQuantity;
        private Long totalPrice;
        private LocalDateTime createdAt;
        private Set<CartList> cartLists;

        public Response(Cart cart) {
            this.cartId = cart.getCartId();
            this.memberId = cart.getMemberId();
            this.totalQuantity = cart.getTotalQuantity();
            this.totalPrice = cart.getTotalPrice();
            this.createdAt = cart.getCreatedAt();
            this.cartLists = cart.getCartLists();
        }
    }
}
