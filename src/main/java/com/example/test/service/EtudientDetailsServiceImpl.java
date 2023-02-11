package com.example.test.service;

import com.example.test.Model.Etudient;
import com.example.test.Model.EtudientDetailsImpl;
import com.example.test.repository.RepoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EtudientDetailsServiceImpl implements UserDetailsService {
    @Autowired
    RepoTest repoTest;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Etudient etudient=repoTest.findEtudientByNom(username);

        if(etudient==null) {
            System.out.println("exception thrown");
            throw new UsernameNotFoundException(username + "not found");
        }
        return new EtudientDetailsImpl(etudient);

    }
}
