package com.example.authentication.controller.component;

import com.example.authentication.model.component.ComponentType;
import com.example.authentication.service.component.ComponentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping("/componentType/{id}")
    public ComponentType getById(@PathVariable("id")int id){
        return this.componentTypeService.getById(id);
    }

    @GetMapping("/componentType")
    public List<ComponentType> findAll(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)int pageNumber,
                                       @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize,
                                       @RequestParam(value = "sortBy",defaultValue = "url1",required = false)String sortBy,
                                       @RequestParam(value = "sortDir",defaultValue = "asc",required = false)String sortDir){
        List<ComponentType> componentTypes = this.componentTypeService.findAll(pageNumber, pageSize, sortBy, sortDir);
        return componentTypes;
    }
}
