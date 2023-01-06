package com.example.authentication.repo.component;

import com.example.authentication.model.component.ComponentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentTypeRepo extends JpaRepository<ComponentType,Integer> {
}
