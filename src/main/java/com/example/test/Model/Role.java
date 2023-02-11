package com.example.test.Model;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter

@AllArgsConstructor
@DynamicUpdate
@EqualsAndHashCode
@Entity
public class Role {
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;
    @Column(nullable=false, unique=true)
    private String name;


    public Role() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
