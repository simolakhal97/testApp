package com.example.test.service;

import com.example.test.Model.Etudient;

import java.util.ArrayList;
import java.util.List;

public class TestService {
List<Etudient> list=new ArrayList<>(  );

public void createEtudient(){
    list=List.of( new Etudient("1","mohammed"),
                   new     Etudient("1","mohammed"),
                   new     Etudient("1","mohammed"),
                  new      Etudient("1","mohammed"));
                  }

                  public List<Etudient> getList(){
               return list;
                  }

}
