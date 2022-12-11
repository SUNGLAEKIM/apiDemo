package com.demo.apiDemo.address;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private Long memberId;
    private String addressName;
    private String receiver;
    private String phoneNumber;
    private String address1;
    private String address2;
    private String zipCode;

    @Builder
    public Address(Long addressId, Long memberId, String addressName, String receiver, String phoneNumber, String address1, String address2, String zipCode) {
        this.addressId = addressId;
        this.memberId = memberId;
        this.addressName = addressName;
        this.receiver = receiver;
        this.phoneNumber = phoneNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
    }

}
