package com.example.authentication.service.component;

import com.example.authentication.exception.ResourceNotFoundException;
import com.example.authentication.model.component.ComponentType;
import com.example.authentication.repo.component.ComponentTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComponentTypeImpl implements ComponentTypeService {

    @Autowired
    private ComponentTypeRepo componentTypeRepo;

    @Override
    public ComponentType save(ComponentType componentType) {
        return this.componentTypeRepo.save(componentType);
    }

    @Override
    public ComponentType update(int id, ComponentType componentType) {
        ComponentType componentType1 = componentTypeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Component_Type With ID: "+id+" Not Found"));
        componentType1.setUrl1(componentType.getUrl1());
        componentType1.setUrl2(componentType.getUrl2());
        componentType1.setUpdated(new Date());
        return this.componentTypeRepo.save(componentType1);
    }

    @Override
    public ComponentType getById(int id) {
        return this.componentTypeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("ComponentType With Id: "+id+" Not Found"));
    }

    @Override
    public void delete(int id) {
        this.componentTypeRepo.deleteById(id);
    }

    @Override
    public List<ComponentType> findAll() {
        return this.componentTypeRepo.findAll();
    }
}
