package com.onechallenge.forumhubby.repository;

import com.onechallenge.forumhubby.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
