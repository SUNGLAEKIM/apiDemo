package com.demo.apiDemo.address;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class Request {
        private Long addressId;
        private Long memberId;
        private String addressName;
        private String receiver;
        private String phoneNumber;
        private String address1;
        private String address2;
        private String zipCode;

        public Address toEntity() {
            Address address = Address.builder()
                    .addressId(addressId)
                    .memberId(memberId)
                    .addressName(addressName)
                    .receiver(receiver)
                    .phoneNumber(phoneNumber)
                    .address1(address1)
                    .address2(address2)
                    .zipCode(zipCode)
                    .build();
            return address;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long addressId;
        private Long memberId;
        private String addressName;
        private String receiver;
        private String phoneNumber;
        private String address1;
        private String address2;
        private String zipCode;

        public Response(Address address) {
            this.addressId = address.getAddressId();
            this.memberId = address.getMemberId();
            this.addressName = address.getAddressName();
            this.receiver = address.getReceiver();
            this.phoneNumber = address.getPhoneNumber();
            this.address1 = address.getAddress1();
            this.address2 = address.getAddress2();
            this.zipCode = address.getZipCode();
        }
    }
}
