package com.onechallenge.forumhubby.model;

import com.onechallenge.forumhubby.dto.DataMemberRegister;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "Member")
@Table(name = "members")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "originalPoster")
    private List<Topic> topics;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commenter")
    private List<Comment> comments;

    public Member(DataMemberRegister dataMemberRegister) {
        this.alias = dataMemberRegister.alias();
        this.email = dataMemberRegister.email();
        this.password = dataMemberRegister.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
