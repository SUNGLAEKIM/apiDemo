package com.demo.apiDemo.member;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String email;
    private String password;
    private String userName;

    @Builder
    public Member(Long memberId, String email, String password, String userName) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }
}
