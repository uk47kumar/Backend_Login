package com.example.authentication.controller.component;

import com.example.authentication.model.component.ComponentType;
import com.example.authentication.service.component.ComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ComponentTypeController {

    @Autowired
    private ComponentTypeService componentTypeService;

    @PostMapping("/saveComponentType")
    public ComponentType save(@ModelAttribute ComponentType componentType){
        componentType.setCreated(new Date());
        return this.componentTypeService.save(componentType);
    }

    @PutMapping("/updateComponentType/{id}")
    public ComponentType update(@PathVariable("id")int id, @ModelAttribute ComponentType componentType){
        return this.componentTypeService.update(id, componentType);
    }

    @DeleteMapping("/deleteComponentType/{id}")
    public String delete(@PathVariable("id")int id){
        this.componentTypeService.delete(id);
        return "ComponentType With Id: "+id+" Is Deleted !";
    }
}
