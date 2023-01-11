package com.example.authentication.service.component;

import com.example.authentication.model.component.Component;

import java.util.List;

public interface ComponentService {
    Component save(Component component);

    Component update(int id, Component component);

    Component getById(int id);

    void delete(int id);
    List<Component> findAll(int pageNumber, int pageSize, String sortBy, String sortDir);
}
