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




                  public Etudient save(Etudient etudient){
                     Etudient etudient1=new Etudient(  );
                     etudient1.setId(etudient.getId());
                     etudient1.setNom(etudient.getNom());
                     list.add(etudient);
                     return etudient;
                  }
                  public String delete(String id){
                  list.removeIf(x->x.getId()==id);
                  return null;
                  }

}
