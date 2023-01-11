package com.example.authentication.service.component;

import com.example.authentication.exception.ResourceNotFoundException;
import com.example.authentication.repo.component.ComponentRepo;
import com.example.authentication.model.component.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        Component component1 = componentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Component With Id: " + id + " Not Found !"));
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
        } catch (Exception e) {
            throw new ResourceNotFoundException("Component With Id: " + id + " Not Found !");
        }
    }

    @Override
    public List<Component> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {

        Sort sort = null;
        if (sortDir.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Component> componentPage = this.componentRepo.findAll(pageable);
        List<Component> content = componentPage.getContent();
        return content;
    }
}
