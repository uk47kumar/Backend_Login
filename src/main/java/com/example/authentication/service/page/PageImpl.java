package com.example.authentication.service.page;

import com.example.authentication.exception.ResourceNotFoundException;
import com.example.authentication.model.page.Page;
import com.example.authentication.repo.page.PageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class PageImpl implements PageService {

    @Autowired
    private PageRepo pageRepo;

    @Override
    public Page save(Page page) {
        return this.pageRepo.save(page);
    }

    @Override
    public Page update(int id, Page page) {
            Page page1 = pageRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Page with Id: "+id+" Not Found !"));
            page1.setUrl2(page.getUrl2());
            page1.setUpdated(new Date());
            return this.pageRepo.save(page1);
    }

    @Override
    public Page getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            this.pageRepo.deleteById(id);
        }catch (Exception e){
            throw new ResourceNotFoundException("Page with Id: "+id+" Not Found !");
        }
    }
}
