package com.example.test.repository;

import com.example.test.Model.Etudient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public interface RepoTest extends CrudRepository<Etudient, Integer> {
       Etudient findEtudientByNom(String Nom);

}
