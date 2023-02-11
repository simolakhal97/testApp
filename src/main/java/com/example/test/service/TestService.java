package com.example.test.service;

import com.example.test.Model.Etudient;


import java.util.List;
import java.util.Optional;

public interface TestService {


    Etudient saveEtudient (Etudient etudient);
          List<Etudient>AfficherEtudient();
           Etudient findUserBynom(String email);
    public Optional<Etudient> findUserById(int id);


}
