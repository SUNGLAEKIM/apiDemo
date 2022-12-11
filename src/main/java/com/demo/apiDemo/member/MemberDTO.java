package com.demo.apiDemo.member;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class Request {
        private Long memberId;
        private String email;
        private String password;
        private String userName;

        public Member toEntity() {
            Member member = Member.builder()
                    .memberId(memberId)
                    .email(email)
                    .password(password)
                    .userName(userName)
                    .build();
            return member;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long memberId;
        private String email;
        private String password;
        private String userName;

        public Response(Member member) {
            this.memberId = member.getMemberId();
            this.email = member.getEmail();
            this.password = member.getPassword();
            this.userName = member.getUserName();
        }
    }
}
