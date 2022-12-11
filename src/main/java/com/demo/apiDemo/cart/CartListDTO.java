package com.demo.apiDemo.cart;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartListDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class Request {
        private Long cartListId;
        private Long cartId;
        private Long productId;
        private Long quantity;
        private Long price;

        public CartList toEntity() {
            CartList cartList = CartList.builder()
                    .cartListId(cartListId)
                    .cartId(cartId)
                    .productId(productId)
                    .quantity(quantity)
                    .price(price)
                    .build();
            return cartList;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long cartListId;
        private Long cartId;
        private Long productId;
        private Long quantity;
        private Long price;

        public Response(CartList cartList) {
            this.cartListId = cartList.getCartListId();
            this.cartId = cartList.getCartId();
            this.productId = cartList.getProductId();
            this.quantity = cartList.getQuantity();
            this.price = cartList.getPrice();
        }
    }
}
