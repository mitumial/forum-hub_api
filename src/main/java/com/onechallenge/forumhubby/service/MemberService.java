package com.onechallenge.forumhubby.service;

import com.onechallenge.forumhubby.dto.DataMemberRegister;
import com.onechallenge.forumhubby.model.Member;
import com.onechallenge.forumhubby.repository.MemberRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository repository;

    public Member registerMember(@Valid DataMemberRegister dataMemberRegister){
        Member member = new Member(dataMemberRegister);
        return repository.save(member);
    }
}
