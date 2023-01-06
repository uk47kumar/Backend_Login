package com.example.authentication.service.component;

import com.example.authentication.exception.ResourceNotFoundException;
import com.example.authentication.repo.component.ComponentRepo;
import com.example.authentication.model.component.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComponentImpl implements ComponentService {

    @Autowired
    private ComponentRepo componentRepo;

    @Override
    public Component save(Component component) {
        return componentRepo.save(component);
    }

    @Override
    public Component getById(int id) {
        return componentRepo.findById(id).get();
    }

    @Override
    public Component update(int id, Component component) {
        Component component1 = componentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Component With Id: "+id+" Not Found !"));
        component1.setComponentName(component.getComponentName());
        component1.setSubComponentName(component.getSubComponentName());
        component1.setComponentOrder(component.getComponentOrder());
        component1.setSubComponentId(component.getSubComponentId());
        component1.setUpdated(new Date());
        component1.setComponentTypeId(component.getComponentTypeId());
        return this.componentRepo.save(component1);
    }

    @Override
    public void delete(int id) {
        try {
            this.componentRepo.deleteById(id);
        }catch (Exception e){
            throw new ResourceNotFoundException("Component With Id: "+id+" Not Found !");
        }
    }

    @Override
    public List<Component> findAll() {
        return this.componentRepo.findAll();
    }
}
