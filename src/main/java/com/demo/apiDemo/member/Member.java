package com.demo.apiDemo.member;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Builder(builderMethodName = "MemberBuilder")

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String email;
    private String password;
    private String userName;

    @Builder
    public Member(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }
}
