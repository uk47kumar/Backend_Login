package com.example.authentication.controller.page;

import com.example.authentication.model.page.Page;
import com.example.authentication.service.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    @PostMapping("/savePage")
    public Page save(@ModelAttribute Page page) {
        page.setCreated(new Date());
        return this.pageService.save(page);
    }

    @PutMapping("/updatePage/{id}")
    public Page update(@PathVariable("id") int id, @ModelAttribute Page page) {
        return this.pageService.update(id, page);
    }

    @DeleteMapping("/deletePage/{id}")
    public String delete(@PathVariable("id")int id){
        this.pageService.delete(id);
        return "page with Id: "+id+" is deleted";
    }
}
