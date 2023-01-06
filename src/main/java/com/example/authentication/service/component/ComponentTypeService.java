package com.example.authentication.service.component;

import com.example.authentication.model.component.ComponentType;

public interface ComponentTypeService {
    ComponentType save(ComponentType componentType);
    ComponentType update(int id, ComponentType componentType);
    ComponentType getById(int id);
    void delete(int id);
}
