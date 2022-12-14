package com.demo.apiDemo.cart;

import com.demo.apiDemo.product.Product;
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
        private Cart cart;
        private Product product;
        private Long quantity;
        private Long price;

        public CartList toEntity() {
            CartList cartList = CartList.builder()
                    .cartListId(cartListId)
                    .cart(cart)
                    .product(product)
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
        private Cart cart;
        private Product product;
        private Long quantity;
        private Long price;

        public Response(CartList cartList) {
            this.cartListId = cartList.getCartListId();
            this.cart = cartList.getCart();
            this.product = cartList.getProduct();
            this.quantity = cartList.getQuantity();
            this.price = cartList.getPrice();
        }
    }
}
