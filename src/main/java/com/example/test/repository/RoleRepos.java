package com.example.test.repository;

import com.example.test.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepos extends JpaRepository<Role,Integer> {
    Role findByName(String name);

}
