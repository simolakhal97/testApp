package com.example.test.service;

import com.example.test.Model.Etudient;

import java.util.List;

public interface TestService {



    Etudient UpdateEtudient(Etudient etudient,int id);

Etudient saveEtudient (Etudient etudient);
List<Etudient>AfficherEtudient();
void deleteEtudient(int id);


}
