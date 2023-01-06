package com.example.authentication.service.component;

import com.example.authentication.model.component.Component;

public interface ComponentService {
    Component save(Component component);

    Component update(int id, Component component);

    Component getById(int id);

    void delete(int id);
}
