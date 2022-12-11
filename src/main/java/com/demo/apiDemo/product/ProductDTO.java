package com.demo.apiDemo.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDTO {

    public static class Request {
        //do nothing
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long productId;
        private Long baseProductId;
        private String productName;
        private int price;
        private String description;

        public Response(Product product) {
            this.productId = product.getProductId();
            this.baseProductId = product.getBaseProductId();
            this.productName = product.getProductName();
            this.price = product.getPrice();
            this.description = product.getDescription();
        }
    }
}
