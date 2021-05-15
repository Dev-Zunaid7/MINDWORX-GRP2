package com.mindworx.alumnibackend.model.users;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AUserDetail implements UserDetails {

    //Set Variables for the user
    @Id
    // @SequenceGenerator(
    //     name = "mindworxuser_sequence",
    //     sequenceName = "mindworxuser_sequence",
    //     allocationSize = 1

    // )
    // @GeneratedValue(
    //     strategy = GenerationType.SEQUENCE,
    //     generator = "mindworxuser_sequence"
    // )
    private int id;
    private String userName;
    private String  password;
    private String  email;
    private boolean active;
    private boolean locked;
    @Enumerated(EnumType.STRING)
    private Usertype userRole;


    public AUserDetail(String userName, String password, String email, boolean active, boolean locked,
            Usertype userRole) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.active = active;
        this.locked = locked;
        this.userRole = userRole;
    }


    public AUserDetail() {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new  SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }


    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return userName;
    }


    @Override
    public boolean isAccountNonExpired() {

        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
     
        return !locked;
    }


    @Override
    public boolean isCredentialsNonExpired() {
       
        return true;
    }


    @Override
    public boolean isEnabled() {
   
        return active;
    }


    
}
