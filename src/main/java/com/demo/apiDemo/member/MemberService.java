package com.demo.apiDemo.member;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member join(MemberDTO.Request memberDTO) {
        return memberRepository.save(memberDTO.toEntity());
    }

    public MemberDTO.Response findByMemberId(Long memberId) {
        return new MemberDTO.Response(memberRepository.findByMemberId(memberId).get());
    }

    public MemberDTO.Response findByEmail(String email) {
        return new MemberDTO.Response(memberRepository.findByEmail(email).get());
    }

    public List<MemberDTO.Response> findAllMember() {
        List<Member> members = memberRepository.findAll();
        List<MemberDTO.Response> memberDTOS = new ArrayList<>();

        for(Member member : members) {
            MemberDTO.Response response = new MemberDTO.Response(member);
            memberDTOS.add(response);
        }

        return memberDTOS;
    }
}
