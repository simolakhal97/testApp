package com.example.test.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EtudientDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Etudient etudient;


    public EtudientDetailsImpl(Etudient etudient) {
        super();
        this.etudient = etudient;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.etudient.getRoles()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.etudient.getPassword();
    }

    @Override
    public String getUsername() {
        return this.etudient.getNom();
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
    public Etudient getEtudientDetails() {
        return etudient;
    }


}
