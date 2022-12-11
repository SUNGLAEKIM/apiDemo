package com.demo.apiDemo.member;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/join")
    public String join() {
        return "join";
    }

    /**
     * 사용자 저장
     * @param memberDTO
     * @return
     * MemberDTO.Request parameter 로 사용자를 저장한다.
     *
     * private Long memberId;
     * private String email;
     * private String password;
     * private String userName;
     *
     */
    @PostMapping(value = "/join")
    public Member join(@RequestBody MemberDTO.Request memberDTO) {
        return memberService.join(memberDTO);
    }

    /**
     * 사용자 조회 (PK)
     * @param memberDTO
     * @return
     * memberId PK로 사용자를 조회한다.
     */
    @GetMapping(value = "/find_by_member_id")
    public MemberDTO.Response findByMemberId(@RequestBody MemberDTO.Response memberDTO) {
        return memberService.findByMemberId(memberDTO.getMemberId());
    }

    /**
     * 사용자 조회 (email)
     * @param memberDTO
     * @return
     * email parameter 로 사용자를 조회한다.
     */
    @GetMapping(value = "/find_by_email")
    public MemberDTO.Response findByEmail(@RequestBody MemberDTO.Response memberDTO) {
        return memberService.findByEmail(memberDTO.getEmail());
    }

    /**
     * 전체 사용자 조회
     * @return
     * 모든 사용자를 조회한다.
     */
    @GetMapping(value = "/find_all_member")
    public List<MemberDTO.Response> findAllMember() {
        return memberService.findAllMember();
    }
}
