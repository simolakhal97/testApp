package com.example.test.config;

import com.example.test.repository.RepoTest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class EtudientSecurity {
    RepoTest repoTest;

    public boolean hasEtudientId(Authentication authentication, Integer Id){
             int etudientId=repoTest.findEtudientByNom(authentication.getName()).getId();
             if(etudientId==Id){
                 return true;
             }
        return false;
    }
}
