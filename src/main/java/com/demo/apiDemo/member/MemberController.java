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

    @PostMapping(value = "/join")
    public Member join(@RequestBody MemberDTO.Request memberDTO) {
        return memberService.join(memberDTO);
    }

    @GetMapping(value = "/find_by_member_id")
    public MemberDTO.Response findByMemberId(@RequestParam("member_id") Long memberId) {
        return memberService.findByMemberId(memberId);
    }

    @GetMapping(value = "/find_by_email")
    public MemberDTO.Response findByEmail(@RequestParam("email") String email) {
        return memberService.findByEmail(email);
    }

    @GetMapping(value = "/find_all_member")
    public List<MemberDTO.Response> findAllMember() {
        return memberService.findAllMember();
    }
}
