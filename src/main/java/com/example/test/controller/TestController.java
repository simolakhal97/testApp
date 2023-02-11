package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Model.Etudient;
import com.example.test.config.EtudientSecurity;
import com.example.test.service.TestService;
import com.example.test.service.TestServicelmp;
import java.util.List;

@RestController
@RequestMapping
@EnableGlobalMethodSecurity(prePostEnabled=true)
    public class TestController {
  @Autowired
  private TestServicelmp testServicelmp;
    @GetMapping("/etudient")
    public List<Etudient> getAllUsers(Authentication authentication) {
        return testServicelmp.AfficherEtudient();

    }

    @PreAuthorize("@userSecurity.hasEtudientId(authentication,#Id)")
    @GetMapping("/users/{etudientId}")
    public ResponseEntity<Etudient> getUserById(@PathVariable("etudientId") int Id, Authentication authentication) {
        System.out.println("Inside getuserbyid method");
        return ResponseEntity.ok().body(testServicelmp.findUserById(Id).get());

    }
    @GetMapping("/save")
    public ResponseEntity<Etudient> saveusers(@RequestBody Etudient newEtudient, Authentication auth) {
        System.out.println(newEtudient.getNom()+"  "+auth.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body((testServicelmp.saveEtudient(newEtudient)));
    }


    @PutMapping("/users/{etudientId}")
    public ResponseEntity<Etudient> updateUser(@PathVariable("etudientId") int Id,@RequestBody Etudient newetudient) {
        return ResponseEntity.ok().body(testServicelmp.updateEtudient(Id,newetudient));

    }

    @DeleteMapping("/Etudient/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") int EtudientId) {
        testServicelmp.deleteEtudient(EtudientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
    @GetMapping("/users/search")
    @PostAuthorize("returnObject.body.EtudientName==authenticated.Etudient")
    public ResponseEntity<Etudient> etudienDetails(Authentication authentication, @RequestParam("cname") String cName) throws Exception {
        System.out.println(authentication.getName().toString());
        Etudient etudient=testServicelmp.findUserBynom(cName);
        if(etudient==null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Etudient not found");
        }
        return ResponseEntity.ok().body(etudient);

    }
}
