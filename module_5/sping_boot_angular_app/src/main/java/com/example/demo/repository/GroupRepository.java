package com.example.demo.repository;

import com.example.demo.model.GroupClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupClass,Integer> {
}
