package com.onechallenge.forumhubby.repository;

import com.onechallenge.forumhubby.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    UserDetails findByEmail(String email);
}
