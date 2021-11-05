package com.marketplace_ecommerce.app.service;

import com.marketplace_ecommerce.app.dao.MemberRepository;
import com.marketplace_ecommerce.app.entity.Member;
import org.springframework.stereotype.Service;

/**
 * @author j0975
 */
@Service
public class MemberServiceImpl implements MemberService{

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository theMemberRepository) {
        this.memberRepository = theMemberRepository;
    }
    @Override
    public Member findByEmail(String theEmail) {
        return memberRepository.findByEmail(theEmail);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }
}
