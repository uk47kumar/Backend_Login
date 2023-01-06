package com.example.authentication.controller.component;

import com.example.authentication.model.component.Component;
import com.example.authentication.service.component.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    @PostMapping("/saveComponent")
    public Component save(@ModelAttribute Component component){
        component.setCreated(new Date());
        return this.componentService.save(component);
    }

    @PutMapping("/updateComponent/{id}")
    public Component update(@PathVariable("id")int id, @ModelAttribute Component component){
        return this.componentService.update(id, component);
    }

    @DeleteMapping("/deleteComponent/{id}")
    public String delete(@PathVariable("id")int id){
        this.componentService.delete(id);
        return "Component with Id: "+id+" Is Deleted";
    }

    @GetMapping("/component/{id}")
    public Component getById(@PathVariable("id")int id){
        return this.componentService.getById(id);
    }

    @GetMapping("/component")
    public List<Component> findAll(){
        return this.componentService.findAll();
    }
}
