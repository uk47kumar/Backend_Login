package com.example.authentication.service.page;

import com.example.authentication.exception.ResourceNotFoundException;
import com.example.authentication.model.page.PageSubList;
import com.example.authentication.repo.page.PageSubListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PageSubListImpl implements PageSubListService {

    @Autowired
    private PageSubListRepo pageSubListRepo;

    @Override
    public PageSubList save(PageSubList pageSubList) {
        return pageSubListRepo.save(pageSubList);
    }

    @Override
    public PageSubList update(int id, PageSubList pageSubList) {
        PageSubList pageSubList1 = pageSubListRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Page_Sub_List With ID: "+id+" NOt Found !"));
        pageSubList1.setPage(pageSubList.getPage());
        pageSubList.setUpdated(new Date());
        return this.pageSubListRepo.save(pageSubList1);
    }

    @Override
    public PageSubList getById(int id) {
        return this.pageSubListRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Page_Sub_List With Id: "+id+" Not Found"));
    }

    @Override
    public void delete(int id) {
        try {
            this.pageSubListRepo.deleteById(id);
        }catch (Exception e){
            throw new ResourceNotFoundException("Page_Sub_List With ID: "+id+" NOt Found !");
        }
    }

    @Override
    public List<PageSubList> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = null;
        if (sortDir.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        }else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);

        Page<PageSubList> subListPage = this.pageSubListRepo.findAll(pageable);
        List<PageSubList> pageContent = subListPage.getContent();
        return pageContent;
    }
}
