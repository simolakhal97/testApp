package com.example.test.service;

import com.example.test.Model.Etudient;
import com.example.test.repository.RepoTest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Component
@RequiredArgsConstructor
public class TestServicelmp implements TestService {
    @Autowired
    RepoTest repoTest;



    public Etudient saveEtudient(Etudient etudient){
        return repoTest.save(etudient);
    }

    @Override
    public List<Etudient> AfficherEtudient() {
        return (List<Etudient>) repoTest.findAll();
    }

    @Override
    public void deleteEtudient(int id) {
        repoTest.deleteById(id);
    }


    public Etudient getetudientbyid(int id ){
        return repoTest.findById(id).get();
    }




    @Override
    public Etudient UpdateEtudient(Etudient etudient,int id) {

        Etudient etudient1=repoTest.findById(id).get();


        if (Objects.nonNull(etudient.getNom())
                && !"".equalsIgnoreCase(
               etudient.getNom())){
                   etudient1.setNom(etudient.getNom());
        }
                return repoTest.save(etudient);
    }

}