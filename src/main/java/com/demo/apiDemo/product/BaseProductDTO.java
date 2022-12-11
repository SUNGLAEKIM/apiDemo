package com.demo.apiDemo.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseProductDTO {

    public static class Request {
        //do nothing
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long baseProductId;
        private String baseProductName;
        private String description;
        private String image;

        public Response(BaseProduct baseProduct) {
            this.baseProductId = baseProduct.getBaseProductId();
            this.baseProductName = baseProduct.getBaseProductName();
            this.description = baseProduct.getDescription();
            this.image = baseProduct.getImage();
        }
    }
}
