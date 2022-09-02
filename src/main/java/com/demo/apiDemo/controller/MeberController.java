package com.demo.apiDemo.controller;

import com.demo.apiDemo.domain.Member;
import com.demo.apiDemo.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/member")
public class MeberController {

    private final MemberService memberService;

    public MeberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/find_id")
    public Optional<Member> findById(@RequestParam("id") Long id) {
        return memberService.findById(id);
    }

    @GetMapping(value = "/find_name")
    public Optional<Member> findByName(@RequestParam("name") String name) {
        return memberService.findByName(name);
    }

    @PostMapping(value = "/save")
    public Member save(@RequestParam("id") Long id, @RequestParam("name") String name){
        Member member = new Member();
        member.setId(id);
        member.setName(name);

        return memberService.save(member);
    }

    @GetMapping(value = "/find_all")
    public List<Member> findAll() {
        return memberService.findAll();
    }
}
