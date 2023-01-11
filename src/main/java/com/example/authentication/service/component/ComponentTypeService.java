package com.example.authentication.service.component;

import com.example.authentication.model.component.ComponentType;

import java.util.List;

public interface ComponentTypeService {
    ComponentType save(ComponentType componentType);
    ComponentType update(int id, ComponentType componentType);
    ComponentType getById(int id);
    void delete(int id);
    List<ComponentType> findAll(int pageNumber, int pageSize, String sortBy, String sortDir);
}
