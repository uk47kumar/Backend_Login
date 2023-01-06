package com.example.authentication.controller.page;

import com.example.authentication.model.page.PageSubList;
import com.example.authentication.service.page.PageSubListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PageSubListController {

    @Autowired
    private PageSubListService pageSubListService;

    @PostMapping("/savePageSubList")
    public PageSubList save(@ModelAttribute PageSubList pageSubList){
        pageSubList.setCreated(new Date());
        return this.pageSubListService.save(pageSubList);
    }

    @PutMapping("/updatePageSubList/{id}")
    public PageSubList update(@PathVariable("id")int id, @ModelAttribute PageSubList pageSubList){
        return this.pageSubListService.update(id, pageSubList);
    }

    @DeleteMapping("/deletePageSubList/{id}")
    public String delete(@PathVariable("id")int id){
        this.pageSubListService.delete(id);
        return "Page_Sub_List With ID: "+id+" Is Deleted";
    }

    @GetMapping("/pageSubList/{id}")
    public PageSubList getById(@PathVariable("id")int id){
        return this.pageSubListService.getById(id);
    }

    @GetMapping("/pageSubList")
    public List<PageSubList> findAll(){
        return this.pageSubListService.findAll();
    }
}
