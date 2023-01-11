package com.example.authentication.service.page;

import com.example.authentication.exception.ResourceNotFoundException;
import com.example.authentication.model.page.Page;
import com.example.authentication.payload.PageResponse;
import com.example.authentication.repo.page.PageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        return this.pageRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Page with Id: "+id+" Not Found"));
    }

    @Override
    public void delete(int id) {
        try {
            this.pageRepo.deleteById(id);
        }catch (Exception e){
            throw new ResourceNotFoundException("Page with Id: "+id+" Not Found !");
        }
    }

    @Override
    public PageResponse findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {

        Sort sort = null;
        if(sortDir.equalsIgnoreCase("asc")){
            sort = Sort.by(sortBy).ascending();
        }else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable p = PageRequest.of(pageNumber,pageSize, sort);

        org.springframework.data.domain.Page<Page> pagePage = this.pageRepo.findAll(p);
        List<Page> allPage = pagePage.getContent();

        PageResponse pageResponse = new PageResponse();
        pageResponse.setContent(allPage);
        pageResponse.setPageNumber(pagePage.getNumber());
        pageResponse.setPageSize(pagePage.getSize());
        pageResponse.setTotalElements(pagePage.getTotalElements());
        pageResponse.setTotalPages(pagePage.getTotalPages());
        pageResponse.setLastPage(pagePage.isLast());

        return pageResponse;
    }
}
