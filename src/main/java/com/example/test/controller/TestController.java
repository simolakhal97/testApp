package com.example.test.controller;

import com.example.test.Model.Etudient;
import com.example.test.repository.RepoTest;
import com.example.test.service.TestServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
    public class TestController {
  @Autowired
  private TestServicelmp testServicelmp;

@GetMapping("/AjouteEtudient")
public ResponseEntity<Etudient>  AjouteEtudient(@RequestBody Etudient etudient){
   Etudient etudient1= testServicelmp.saveEtudient(etudient);
    return new ResponseEntity<>(etudient1, HttpStatus.CREATED);
}
@GetMapping("/Affiche")
public ResponseEntity<List<Etudient>> getAllEtudient(){
   List<Etudient> etudients= testServicelmp.AfficherEtudient();
    return new ResponseEntity<>(etudients,HttpStatus.OK);
}
@GetMapping("{id}")
public Etudient Findetudientbyid(@PathVariable int id){
    return testServicelmp.getetudientbyid(id);
}


@PutMapping("{id}")
public Etudient UpdateEtudient(@RequestBody Etudient etudient,@PathVariable("id")int id){
    return testServicelmp.UpdateEtudient(etudient,id);
}
@DeleteMapping("{id}")
public String deletEtudient(@PathVariable("id") int id){

            testServicelmp.deleteEtudient(id);
            return "Deleted Successfully";
}

}
