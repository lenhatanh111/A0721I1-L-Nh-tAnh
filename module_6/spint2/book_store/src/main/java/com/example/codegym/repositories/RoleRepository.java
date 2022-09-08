package com.example.codegym.repositories;

import com.example.codegym.common.enums.ERole;
import com.example.codegym.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    Role findByName(String name);
}
