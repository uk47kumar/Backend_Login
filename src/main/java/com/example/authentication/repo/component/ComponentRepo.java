package com.example.authentication.repo.component;

import com.example.authentication.model.component.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepo extends JpaRepository<Component,Integer> {
}
