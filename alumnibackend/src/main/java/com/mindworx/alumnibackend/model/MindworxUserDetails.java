package com.mindworx.alumnibackend.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import com.mindworx.alumnibackend.model.users.MindworxGroup;
import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MindworxUserDetails implements UserDetails {

    private final Mindworxuser mindworxuser;

    @Autowired
    public MindworxUserDetails(Mindworxuser mindworxuser) {
        this.mindworxuser = mindworxuser;
    }

    // methods for user security verification.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // SimpleGrantedAuthority authority = new SimpleGrantedAuthority("Ass");
        Set<MindworxGroup> userGroups = mindworxuser.getUserGroups();
        Collection<GrantedAuthority> authorities = new ArrayList<>(userGroups.size());
        for (MindworxGroup userGroup : userGroups) {
            authorities.add(new SimpleGrantedAuthority(userGroup.getCode().toUpperCase()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {

        return mindworxuser.getPassword();
    }

    @Override
    public String getUsername() {

        return mindworxuser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return !mindworxuser.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return mindworxuser.isEnabled();
    }

    public String getFullname(){
        return this.mindworxuser.getFirstName() + " " + this.mindworxuser.getLastName();
    }

}
