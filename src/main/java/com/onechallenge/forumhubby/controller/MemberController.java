package com.onechallenge.forumhubby.controller;

import com.onechallenge.forumhubby.dto.DataMemberRegister;
import com.onechallenge.forumhubby.model.Member;
import com.onechallenge.forumhubby.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/register")
public class MemberController {
    @Autowired
    private MemberService service;

    @PostMapping
    public ResponseEntity<DataMemberRegister> registerMember(@RequestBody @Valid DataMemberRegister dataMemberRegister, UriComponentsBuilder uriComponentsBuilder){
        Member member = service.registerMember(dataMemberRegister);
        URI url = uriComponentsBuilder.path("/members/{id}").buildAndExpand(member.getId()).toUri();
        return ResponseEntity.created(url).body(dataMemberRegister);
    }
}
