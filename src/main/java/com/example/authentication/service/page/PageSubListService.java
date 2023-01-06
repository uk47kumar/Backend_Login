package com.example.authentication.service.page;

import com.example.authentication.model.page.PageSubList;

import java.util.List;

public interface PageSubListService {

    PageSubList save(PageSubList pageSubList);
    PageSubList update(int id, PageSubList pageSubList);
    PageSubList getById(int id);
    void delete(int id);
    List<PageSubList> findAll();
}
