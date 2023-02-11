package com.example.test.service;


import com.example.test.Model.Etudient;
import com.example.test.repository.RepoTest;
import com.example.test.repository.RoleRepos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
@Component
@RequiredArgsConstructor
public class TestServicelmp implements TestService {
    @Autowired
    RepoTest repoTest;

    @Override
    public Etudient saveEtudient(Etudient etudient) {

       Etudient etudient1=repoTest.save(etudient);
        return etudient1;

    }
    @Override
    public List<Etudient> AfficherEtudient() {
      return (List<Etudient>) repoTest.findAll();
    }

    @Override
    public Etudient findUserBynom(String nom) {
        Etudient etudient=repoTest.findEtudientByNom(nom);
        return etudient;
    }
    public Optional<Etudient> findUserById(int id) {
        return repoTest.findById(id);
    }
    public Etudient updateEtudient(int id,Etudient etudient) {

        Optional<Etudient> retrievedEtudient=repoTest.findById(id);
        if(retrievedEtudient==null)
            try {
                throw new Exception("Etudient not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        repoTest.save(etudient);
        return repoTest.findById(id).get();

    }

    public Etudient deleteEtudient(int EtudientrId) {

        Optional<Etudient> removeEtudient=repoTest.findById(EtudientrId);
        if(removeEtudient==null)
            try {
                throw new Exception("Etudient not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        repoTest.deleteById(EtudientrId);
        return removeEtudient.get();

    }
    }