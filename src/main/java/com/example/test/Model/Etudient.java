package com.example.test.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Etudient {
    @Id
   int id;
    String nom;

    public Etudient(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Etudient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
